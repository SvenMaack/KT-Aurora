package landingpagedata.data

import arrow.core.Either
import arrow.core.mapOrAccumulate
import arrow.core.raise.either
import com.datastax.oss.driver.api.core.cql.Row
import me.tatarka.inject.annotations.Inject

private data class CassandraNavigationEntry(
    override val page: Int,
    override val language: String,
    override val title: String,
    override val url: String
): NavigationEntry

@Inject
internal class PersistedLandingPage(
    private val systemRepository: SystemRepository,
    private val repository: Repository
): LandingPage {
    override suspend fun init(): Either<DatabaseError, Unit> =
        either {
            if(!systemRepository.hasKeyspace().bind()) {
                println("init landingPage database")
                systemRepository
                    .createKeySpace().bind()
                    .createTable().bind()

                println("init landingPage data")
                repository.insert(*dummyData.toTypedArray())
                    .mapOrAccumulate(DatabaseError::plus) {
                        it.bind()
                    }.bind()
            } else
                println("init of landingPage not needed")
        }

    override suspend fun get(): Either<DatabaseError, List<NavigationEntry>> =
        either {
            repository.get(1, "en").bind()
                .await()
                .currentPage()
                .map{ row: Row ->
                    CassandraNavigationEntry(
                        page = 1,
                        title = row.getString("title") ?: "",
                        language = "en",
                        url = row.getString("url") ?: ""
                    )
                }
        }

}
