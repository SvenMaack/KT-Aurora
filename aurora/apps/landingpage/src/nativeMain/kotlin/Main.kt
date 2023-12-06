import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import landingPage.landingPage
import landingPage.pageData
import page_lib.page.PageContext
import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage
import template.tags.enums.minus

fun main() {
    embeddedServer(CIO, configure = {
        connectionIdleTimeoutSeconds = 30
    }, port = 8080) {
        routing {
            route("", HttpMethod.Get) {
                handle {
                    call.response.header(HttpHeaders.ContentType, "text/html")
                    call.respondText(landingPage.getHtml(PageContext(GeneralLanguage.English-CountryCode.UNITED_STATES), pageData))
                }
            }
            route("/${landingPage.getExternalCssPath()}", HttpMethod.Get) {
                handle {
                    call.response.header(HttpHeaders.ContentType, "text/css")
                    call.respondText(landingPage.getExternalCss())
                }
            }
        }
    }.start(wait=true)
}
