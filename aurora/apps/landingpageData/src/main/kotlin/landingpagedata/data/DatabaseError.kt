package landingpagedata.data

internal data class DatabaseError(
    val message: String,
    val cause: Throwable? = null
)

internal operator fun DatabaseError.plus(second: DatabaseError): DatabaseError =
    DatabaseError(message + ", ${second.message}", second.cause)
