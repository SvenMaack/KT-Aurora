@file:OptIn(ExperimentalForeignApi::class, ExperimentalForeignApi::class)

import example.HeadDto
import example.PageDto
import example.PageModule
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import template_lib.TemplateRenderer
import template_lib.base.debugContext
import template_lib.base.productionContext
import platform.posix.*
import kotlin.time.measureTime

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
    var elapsed = measureTime {
        for (i in 1..times) {
            block()
        }
    }
    elapsed = elapsed.div(times.toDouble())
    println("Duration ${elapsed.inWholeMilliseconds} Milliseconds, ${elapsed.inWholeMicroseconds} Microseconds, ${elapsed.inWholeNanoseconds} NanoSeconds")
}

fun main() {
    //warmup
    TemplateRenderer.render(productionContext, PageModule, pageData)

    executeMeasured {
        TemplateRenderer.render(productionContext, PageModule, pageData)
    }

    val html = TemplateRenderer.render(debugContext, PageModule, pageData)
    println(html)
    writeAllText("./out/html/test.html", html)
}
