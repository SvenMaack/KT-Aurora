package template_lib.base

public class TransientTag: TagWithText("") {
    override fun traverse(visitor: Visitor<*>) {
        children.forEach { it.traverse(visitor) }
    }
}
