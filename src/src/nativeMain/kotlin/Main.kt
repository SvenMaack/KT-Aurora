
import css_lib.visitors.ProductionVisitor
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import landingpage.LandingPageDto
import landingpage.landingPage
import modules_lib.navigation.NavigationDto
import page_lib.HeadDto
import page_lib.PageSeoDto
import page_lib.productionContext
import platform.posix.EOF
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fputs
import kotlin.time.measureTime

val seoData: PageSeoDto = PageSeoDto("Hello World", "description", "keyword1, keyword2")
val headData: HeadDto = HeadDto(seoData)
val navigationDto: NavigationDto = NavigationDto(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(headData, navigationDto)

@OptIn(ExperimentalForeignApi::class)
fun writeAllText(filePath:String, text:String) {
    val file = fopen(filePath, "w") ?:
        throw IllegalArgumentException("Cannot open output file $filePath")
    try {
        memScoped {
            if(fputs(text, file) == EOF) throw Error("File write error")
        }
    } finally {
        fclose(file)
    }
}

fun main() {
    val times = 10_000
    landingPage.renderPage(productionContext, pageData)

    var elapsed = measureTime {
        runBlocking {
            repeat(times) {
                launch {
                    landingPage.renderPage(productionContext, pageData)
                }
            }
        }
        landingPage.renderPage(productionContext, pageData)
    }
    elapsed = elapsed.div(times.toDouble())
    println("Duration ${elapsed.inWholeMilliseconds} Milliseconds, ${elapsed.inWholeMicroseconds} Microseconds, ${elapsed.inWholeNanoseconds} NanoSeconds")

    writeAllText("./out/html/test.html", landingPage.renderPage(productionContext, pageData))
    writeAllText("./out/html/${landingPage.getId()}.css", landingPage.getCss(ProductionVisitor()))
    println(landingPage.getMinimumBrowserVersions())
}
