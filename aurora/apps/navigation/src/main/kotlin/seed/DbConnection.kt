package seed

import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.SimpleStatement

internal interface DbConnection {
    fun getKeyspace(): String
    fun execute(query: SimpleStatement): ResultSet
}
