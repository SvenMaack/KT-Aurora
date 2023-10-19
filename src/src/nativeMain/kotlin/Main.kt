import example.HeadDto
import example.PageDto
import kotlinx.cinterop.memScoped
import lib.Context
import lib.tags.DebugVisitor
import lib.tags.ProductionVisitor
import platform.posix.EOF
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fputs
import kotlin.system.measureNanoTime

val headData: HeadDto = HeadDto("World")
val pageData: PageDto = PageDto(headData)

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

fun executeMeasured(block: (visitor: ProductionVisitor) -> Unit) {
    val times = 1000L
    var elapsed = measureNanoTime {
        for (i in 1..times) {
            block(ProductionVisitor())
        }
    }
    elapsed /= times
    println("Duration ${elapsed / (1000*1000)} Milliseconds, ${(elapsed / (1000) % 1000)} Microseconds, ${(elapsed % 1000)} NanoSeconds")
}

fun main() {
    executeMeasured {
        pageData.template(Context { ProductionVisitor() }, pageData).traverse(it)
        it.html
    }

    val visitor = DebugVisitor()
    pageData.template(Context { DebugVisitor() }, pageData).traverse(visitor)
    println(visitor.html)
    writeAllText("./test.html", visitor.html)
}
