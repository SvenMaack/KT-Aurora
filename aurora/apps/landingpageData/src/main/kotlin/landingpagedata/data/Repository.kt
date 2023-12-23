package landingpagedata.data

import arrow.core.Either
import com.datastax.oss.driver.api.core.cql.AsyncResultSet
import kotlinx.coroutines.Deferred

internal interface Repository {
    suspend fun insert(vararg entry: NavigationEntry): List<Either<DatabaseError, AsyncResultSet>>
    suspend fun get(page: Int, language: String): Either<DatabaseError, Deferred<AsyncResultSet>>
}
