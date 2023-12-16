package landingPage.gateway

import landingPage.server.HttpStatusCode

public interface Error {
    public val message: String
    public val errorCode: HttpStatusCode

    public data class NotFound(val id: String): Error {
        override val message: String = "The requested LandingPage is not found"
        override val errorCode: HttpStatusCode = HttpStatusCode.NotFound
    }

    public object NullId: Error {
        override val message: String = "An id of the LandingPage is needed"
        override val errorCode: HttpStatusCode = HttpStatusCode.InternalServerError
    }
}
