package landingpagedata.data.db

import landingpagedata.DATA_CENTER
import landingpagedata.HOSTNAME
import landingpagedata.PORT
import arrow.core.Either
import arrow.core.raise.catch
import arrow.core.raise.either
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.AsyncResultSet
import com.datastax.oss.driver.api.core.cql.BoundStatement
import com.datastax.oss.driver.api.core.cql.PreparedStatement
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.datastax.oss.driver.api.core.cql.Statement
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.future.asDeferred
import landingpagedata.data.DatabaseConnection
import landingpagedata.data.DatabaseError
import java.net.InetSocketAddress

internal object CassandraConnection: DatabaseConnection {
    private val session: Lazy<CqlSession> =
        lazy {
            CqlSession.builder()
                .addContactPoint(InetSocketAddress(HOSTNAME, PORT))
                .withLocalDatacenter(DATA_CENTER)
                .build()
        }

    override suspend fun execute(query: Statement<*>): Either<DatabaseError, Deferred<AsyncResultSet>> =
        either {
            catch(
                {
                    session.value.executeAsync(query).asDeferred()
                },
                { //leaking error in none-structured async code
                    raise(
                        DatabaseError(
                            message = "Error executing query: $query raised from $it",
                            cause = it
                        )
                    )
                }
            )
        }

    override fun prepare(query: SimpleStatement): Either<DatabaseError, PreparedStatement> =
        either {
            catch(
                {
                    session.value.prepare(query)
                },
                { //leaking error in none-structured async code
                    raise(
                        DatabaseError(
                            message = "Error preparing query: ${query.query} raised from $it",
                            cause = it
                        )
                    )
                }
            )
        }


    override fun close() {
        if(session.isInitialized())
            session.value.close()
    }
}

//TODO
internal suspend fun SimpleStatement.execute(): Either<DatabaseError, Deferred<AsyncResultSet>> =
    CassandraConnection.execute(this)
internal suspend fun BoundStatement.execute(): Either<DatabaseError, Deferred<AsyncResultSet>> =
    CassandraConnection.execute(this)
internal fun SimpleStatement.prepare(): Either<DatabaseError, PreparedStatement> =
    CassandraConnection.prepare(this)
