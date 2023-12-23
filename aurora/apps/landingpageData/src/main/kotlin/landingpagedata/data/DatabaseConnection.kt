package landingpagedata.data

import arrow.core.Either
import com.datastax.oss.driver.api.core.cql.AsyncResultSet
import com.datastax.oss.driver.api.core.cql.PreparedStatement
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.datastax.oss.driver.api.core.cql.Statement
import kotlinx.coroutines.Deferred

internal interface DatabaseConnection {
    suspend fun execute(query: Statement<*>): Either<DatabaseError, Deferred<AsyncResultSet>>
    fun prepare(query: SimpleStatement): Either<DatabaseError, PreparedStatement>
    fun close()
}
