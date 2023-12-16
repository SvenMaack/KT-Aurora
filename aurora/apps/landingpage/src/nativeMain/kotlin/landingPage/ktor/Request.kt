package landingPage.ktor

public data class Request(
    public val queryParameters: Map<String, String>,
    public val uri: String
)
