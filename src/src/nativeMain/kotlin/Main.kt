import example.HeadDto
import example.PageDto
import kotlinx.cinterop.memScoped
import lib.Context
import lib.TemplateRenderer
import lib.tags.DebugVisitor
import lib.tags.ProductionVisitor
import platform.posix.EOF
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fputs
import kotlin.system.measureNanoTime

val headData: HeadDto = HeadDto("World")
val pageData: PageDto = PageDto(headData)
val productionContext: Context = Context { ProductionVisitor() }
val debugContext: Context = Context { DebugVisitor() }

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

fun executeMeasured(block: () -> Unit) {
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
    executeMeasured {
        TemplateRenderer.render(productionContext, pageData.template, pageData)
    }

    val html = TemplateRenderer.render(debugContext, pageData.template, pageData)
    println(html)
    writeAllText("./test.html", html)
}
