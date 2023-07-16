import example.page1
import lib.DebugVisitor

fun main() {
    with(DebugVisitor()) {
        page1.traverse(this)
        println(this.html)
    }
}
