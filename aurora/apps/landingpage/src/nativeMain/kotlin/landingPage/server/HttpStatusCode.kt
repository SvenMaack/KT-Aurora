package landingPage.server

public enum class HttpStatusCode(public val code: Int) {
    OK(200),

    NotFound(404),

    InternalServerError(500),
}
