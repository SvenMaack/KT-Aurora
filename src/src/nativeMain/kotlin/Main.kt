import example.HeadDto
import example.PageDto
import kotlinx.cinterop.memScoped
import lib.TemplateRenderer
import lib.base.debugContext
import lib.base.productionContext
import platform.posix.EOF
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fputs
import kotlin.system.measureNanoTime

val headData: HeadDto = HeadDto("World")
val pageData: PageDto = PageDto(headData)

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
    var elapsed = measureNanoTime {
        for (i in 1..times) {
            block()
        }
    }
    elapsed /= times
    println("Duration ${elapsed / (1000*1000)} Milliseconds, ${(elapsed / (1000) % 1000)} Microseconds, ${(elapsed % 1000)} NanoSeconds")
}

fun main() {
    //warmup
    TemplateRenderer.render(productionContext, pageData.dynamicTemplate, pageData)

    executeMeasured {
        TemplateRenderer.render(productionContext, pageData.dynamicTemplate, pageData)
    }

    val html = TemplateRenderer.render(debugContext, pageData.dynamicTemplate, pageData)
    println(html)
    writeAllText("./out/html/test.html", html)
}
