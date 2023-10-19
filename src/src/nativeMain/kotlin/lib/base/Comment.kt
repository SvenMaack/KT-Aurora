package lib.base

import lib.tags.Tag

class Comment(comment: String): Tag("!--$comment--") {
    override fun traverse(visitor: Visitor) {
        visitor.visitComment(this)
    }
}
