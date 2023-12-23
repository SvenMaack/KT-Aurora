package landingPage.gateway

public interface Error {
    public val message: String
    public val errorCode: server.HttpStatusCode

    public data class NotFound(val id: String): Error {
        override val message: String = "The requested LandingPage is not found"
        override val errorCode: server.HttpStatusCode = server.HttpStatusCode.NotFound
    }

    public object NullId: Error {
        override val message: String = "An id of the LandingPage is needed"
        override val errorCode: server.HttpStatusCode = server.HttpStatusCode.InternalServerError
    }
}
