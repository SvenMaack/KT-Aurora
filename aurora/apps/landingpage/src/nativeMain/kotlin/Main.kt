import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import landingpage.landingPage
import landingpage.pageData
import page_lib.productionContext

fun main() {
    embeddedServer(CIO, configure = {
        connectionIdleTimeoutSeconds = 30
    }, port = 8080) {
        routing {
            route("", HttpMethod.Get) {
                handle {
                    call.response.header(HttpHeaders.ContentType, "text/html")
                    call.respondText(landingPage.getHtml(productionContext, pageData))
                }
            }
            route("/${landingPage.cssPath}", HttpMethod.Get) {
                handle {
                    call.response.header(HttpHeaders.ContentType, "text/css")
                    call.respondText(landingPage.getCss())
                }
            }
        }
    }.start(wait=true)
}