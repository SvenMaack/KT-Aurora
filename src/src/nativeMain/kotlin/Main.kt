import css_lib.visitors.ProductionVisitor
import landingpage.LandingPageDto
import landingpage.landingPage
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import page_lib.*
import platform.posix.*
import kotlin.time.measureTime

val seoData: PageSeoDto = PageSeoDto("Hello World", "description", "keyword1, keyword2")
val headData: HeadDto = HeadDto(seoData)
val pageData: LandingPageDto = LandingPageDto(headData)

@OptIn(ExperimentalForeignApi::class)
inline fun writeAllText(filePath:String, text:String) {
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

inline fun executeMeasured(block: () -> Unit) {
    val times = 1000L
    var elapsed = measureTime {
        for (i in 1..times) {
            block()
        }
    }
    elapsed = elapsed.div(times.toDouble())
    println("Duration ${elapsed.inWholeMilliseconds} Milliseconds, ${elapsed.inWholeMicroseconds} Microseconds, ${elapsed.inWholeNanoseconds} NanoSeconds")
}

fun main() {
    landingPage.renderPage(productionContext, pageData)
    executeMeasured {
        landingPage.renderPage(productionContext, pageData)
    }

    writeAllText("./out/html/test.html", landingPage.renderPage(productionContext, pageData))
    writeAllText("./out/html/${landingPage.getUniqueId()}.css", landingPage.getCss(ProductionVisitor()))
}
