import css_lib.visitors.ProductionVisitor
import page_lib.HeadDto
import example.PageDto
import example.page
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import template_lib.base.debugContext
import template_lib.base.productionContext
import platform.posix.*
import kotlin.time.measureTime

val headData: HeadDto = HeadDto("World")
val pageData: PageDto = PageDto(headData)

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
    page.renderPage(productionContext, pageData)
    executeMeasured {
        page.renderPage(productionContext, pageData)
    }

    writeAllText("./out/html/test.html", page.renderPage(debugContext, pageData))
    writeAllText("./out/html/test.css", page.getCss(ProductionVisitor()))
}
