package server

public data class HttpMethod(
    public val method: String
) {
    public companion object {
        public val Get: HttpMethod = HttpMethod("GET")
        public val Post: HttpMethod = HttpMethod("POST")
        public val Patch: HttpMethod = HttpMethod("Patch")
        public val Delete: HttpMethod = HttpMethod("Delete")
    }
}
