import example.page1
import kotlinx.cinterop.memScoped
import lib.DebugVisitor
import platform.posix.EOF
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fputs

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
    with(DebugVisitor()) {
        page1.traverse(this)
        println(this.html)
        writeAllText("./test.html", this.html)
    }
}
