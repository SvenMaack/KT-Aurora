package template.base

public class TransientTag: TagWithText("") {
    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        children.forEach { it.traverse(htmlVisitor) }
    }
}
