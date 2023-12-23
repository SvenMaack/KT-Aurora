import landingPage.gateway.Error
import landingPage.gateway.LandingPage
import server.Request
import server.ServerComponent
import server.create
import server.endpoints.CssEndpoint
import server.endpoints.HtmlEndpoint

public fun main() {
    val port = 8080
    println("Server will start at http://localhost:$port/?id=1")

    val server = ServerComponent::class
        .create()
        .server

    server.initEndpoint(
        HtmlEndpoint(
            path = "",
            block = { request: Request ->
                LandingPage.getHtml(
                    id = request.queryParameters["id"],
                    currentUrl = request.toUri()
                )
            },
            recover = { error: Error ->
                Pair(error.errorCode, error.message)
            }
        )
    ).initEndpoint(
        CssEndpoint(
            path = "/${LandingPage.getExternalCssPath()}",
            css = LandingPage.getExternalCss()
        )
    ).start()
}
