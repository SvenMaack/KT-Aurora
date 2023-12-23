package landingpagedata.data.db

import arrow.core.Either
import arrow.core.raise.either
import com.datastax.oss.driver.api.core.cql.AsyncResultSet
import com.datastax.oss.driver.api.core.cql.PreparedStatement
import com.datastax.oss.driver.api.core.type.DataTypes
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.insertInto
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createTable
import landingpagedata.data.DatabaseError
import landingpagedata.data.NavigationEntry
import landingpagedata.data.Repository
import landingpagedata.data.SystemRepository
import kotlinx.coroutines.coroutineScope
import me.tatarka.inject.annotations.Inject
import java.util.UUID
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.*
import kotlinx.coroutines.Deferred

@Inject
internal class LandingPageRepository: SystemRepository, Repository {
    private val keySpace = "landingpage"
    private val table = "landing_page"
    private var selectStatement: PreparedStatement? = null

    override suspend fun hasKeyspace(): Either<DatabaseError, Boolean> =
        either {
            selectFrom("system_schema", "keyspaces")
                .column("keyspace_name")
                .build()
                .execute().bind()
                .await()
                .currentPage()
                .fold(false) { acc, row ->
                    acc || row.getString("keyspace_name") == keySpace
                }
        }

    override suspend fun createKeySpace(): Either<DatabaseError, SystemRepository> =
        either {
            SchemaBuilder
                .createKeyspace(keySpace)
                .withSimpleStrategy(1)
                .build()
                .execute().bind()
                .await()
            this@LandingPageRepository
        }

    override suspend fun createTable(): Either<DatabaseError, SystemRepository> =
        either {
            createTable(keySpace, table)
                .withPartitionKey("page", DataTypes.INT)
                .withClusteringColumn("language", DataTypes.TEXT)
                .withClusteringColumn("id", DataTypes.UUID)
                .withColumn("title", DataTypes.TEXT)
                .withColumn("url", DataTypes.TEXT)
                .build()
                .execute().bind()
                .await()
            this@LandingPageRepository
        }

    override suspend fun insert(vararg entry: NavigationEntry): List<Either<DatabaseError, AsyncResultSet>> =
        coroutineScope {
            entry.map {
                insertInto(keySpace, table)
                    .value("page", literal(it.page))
                    .value("language", literal(it.language))
                    .value("id", literal(UUID.randomUUID()))
                    .value("title", literal(it.title))
                    .value("url", literal(it.url))
                    .build()
                    .execute()
            }.await()
        }

    override suspend fun get(page: Int, language: String): Either<DatabaseError, Deferred<AsyncResultSet>> =
        either {
            getSelectStatement().bind()
                .bind()
                .execute().bind()
        }

    private suspend fun <ERROR, DATA> List<Either<ERROR, Deferred<DATA>>>.await() : List<Either<ERROR, DATA>> =
        this.map {
            either{
                it.bind().await()
            }
        }

    private fun getSelectStatement(): Either<DatabaseError, PreparedStatement> =
        either{
            selectStatement
                ?:  selectFrom(keySpace, table)
                    .column("title")
                    .column("url")
                    .whereColumn("page")
                    .isEqualTo(literal(1))
                    .whereColumn("language")
                    .isEqualTo(literal("en"))
                    .build()
                    .prepare().bind()
                    .apply {
                        this@LandingPageRepository.selectStatement = this
                    }
        }
}
