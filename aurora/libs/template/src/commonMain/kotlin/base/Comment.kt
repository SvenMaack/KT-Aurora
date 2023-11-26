package template_lib.base

public class Comment(comment: String): Tag("!--$comment--") {
    override fun traverse(visitor: Visitor<*>) {
        visitor.visitComment(this)
    }
}
