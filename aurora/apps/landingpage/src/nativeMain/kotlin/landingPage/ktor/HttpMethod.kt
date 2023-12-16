package landingPage.ktor

public data class HttpMethod(
    public val method: String
) {
    public companion object {
        public val Get: HttpMethod = HttpMethod("GET")
    }
}
