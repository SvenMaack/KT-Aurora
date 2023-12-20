package seed

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.net.InetSocketAddress

internal class CassandraConnection(private val configuration: Configuration) : DbConnection, AutoCloseable {
    private val session: CqlSession = CqlSession.builder()
        .addContactPoint(InetSocketAddress(configuration.hostname, configuration.port))
        .withLocalDatacenter(configuration.dataCenter)
        .build()

    override fun getKeyspace(): String =
        configuration.keyspace

    override fun execute(query: SimpleStatement): ResultSet =
        session.execute(query)

    override fun close() {
        session.close()
    }
}
