import landingPage.gateway.Error
import landingPage.gateway.LandingPage
import landingPage.server.Request
import landingPage.server.ResponseFunction
import landingPage.server.endpoints.CssEndpoint
import landingPage.server.endpoints.HtmlEndpoint
import landingPage.server.servers.KtorServer

public fun main() {
    val port = 8080
    println("Server will start at http://localhost:$port/?id=1")

    KtorServer(port)
        .initEndpoint(HtmlEndpoint(
            path = "",
            block = { request: Request ->
                LandingPage.getHtml(
                    id = request.queryParameters["id"],
                    currentUrl = request.toUri()
                )
            },
            recover = { error: Error, response: ResponseFunction<String> ->
                response(error.errorCode, error.message)
            }
        ))
        .initEndpoint(CssEndpoint(
            path = "/${LandingPage.getExternalCssPath()}",
            css = LandingPage.getExternalCss()
        ))
        .start()
}
