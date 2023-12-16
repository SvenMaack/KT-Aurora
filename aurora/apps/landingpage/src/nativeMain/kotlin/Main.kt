import io.ktor.server.response.*
import landingPage.gateway.LandingPage
import landingPage.ktor.CssEndpoint
import landingPage.ktor.HtmlEndpoint
import landingPage.ktor.KtorServer

public fun main() {
    val port = 8080
    KtorServer(port)
        .initEndpoint(HtmlEndpoint(
            path = "",
            block = { call ->
                LandingPage.getHtml(
                    id = call.request.queryParameters["id"]
                )
            },
            recover = { call, e ->
                call.respond(e.errorCode, e.message)
            }
        ))
        .initEndpoint(CssEndpoint(
            path = "/${LandingPage.getExternalCssPath()}",
            css = LandingPage.getExternalCss()
        ))
        .start()

    println("Server started at http://localhost:$port/?id=1")
}
