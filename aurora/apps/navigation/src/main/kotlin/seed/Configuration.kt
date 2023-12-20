package seed

internal data class Configuration(
    val hostname: String = "localhost",
    val port: Int = 9042,
    val dataCenter: String = "datacenter1",
    val keyspace: String = "navigation"
)
