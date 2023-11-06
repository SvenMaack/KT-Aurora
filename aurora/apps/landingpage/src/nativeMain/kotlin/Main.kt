import css_lib.visitors.ProductionVisitor
import io.ktor.http.*
import io.ktor.server.application.*
import landingpage.LandingPageDto
import modules_lib.navigation.NavigationDto
import page_lib.HeadDto
import page_lib.PageSeoDto
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import landingpage.landingPage
import page_lib.productionContext

val seoData: PageSeoDto = PageSeoDto("Hello World", "description", "keyword1, keyword2")
val headData: HeadDto = HeadDto(seoData)
val navigationDto: NavigationDto = NavigationDto(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(headData, navigationDto)

fun main() {
    println("Hello, Kotlin/Native!")
    embeddedServer(CIO, configure = {
        connectionIdleTimeoutSeconds = 45
    }, port = 8085) {
        routing {
            route("/hello", HttpMethod.Get) {
                handle {
                    call.response.header(HttpHeaders.ContentType, "text/html")
                    call.respondText(landingPage.renderPage(productionContext, pageData))
                }
            }
            route("/test.css", HttpMethod.Get) {
                handle {
                    call.response.header(HttpHeaders.ContentType, "text/css")
                    call.respondText(landingPage.getCss(ProductionVisitor()))
                }
            }
        }
    }.start(wait=true)
}