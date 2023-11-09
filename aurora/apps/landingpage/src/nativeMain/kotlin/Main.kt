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