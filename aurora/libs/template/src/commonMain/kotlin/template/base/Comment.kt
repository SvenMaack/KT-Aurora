package template.base

public class Comment(comment: String): Tag("!--$comment--") {
    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        htmlVisitor.visitComment(this)
    }
}
