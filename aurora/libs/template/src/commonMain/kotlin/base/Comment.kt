package template_lib.base

class Comment(comment: String): Tag("!--$comment--") {
    override fun traverse(visitor: Visitor<*>) {
        visitor.visitComment(this)
    }
}
