import landingPage.gateway.Error
import landingPage.gateway.LandingPage
import landingPage.ktor.Request
import landingPage.ktor.ResponseFunction
import landingPage.ktor.endpoints.CssEndpoint
import landingPage.ktor.endpoints.HtmlEndpoint
import landingPage.ktor.servers.KtorServer

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
