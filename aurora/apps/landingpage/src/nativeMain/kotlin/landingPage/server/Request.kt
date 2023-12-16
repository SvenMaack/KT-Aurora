package landingPage.server

public data class Request(
    public val queryParameters: Map<String, String>,
    public val path: String,
) {
    public fun toUri(): String {
        val keys = queryParameters.keys.sorted()
        return keys.joinToString("&") { key -> "$key=${queryParameters[key]}" }
            .let { query ->
                if (query.isNotEmpty()) {
                    "$path?$query"
                } else {
                    path
                }
            }
    }
}
