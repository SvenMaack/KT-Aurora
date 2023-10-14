package lib

import lib.base.TagContainer
import lib.base.Visitor

class Html: TagContainer("html") {
    inline fun body(init: Body.() -> Unit) = add(Body(), init)
    inline fun head(init: Head.() -> Unit) = add(Head(), init)

    override fun traverse(visitor: Visitor) {
        DocType.traverse(visitor)
        super.traverse(visitor)
    }
}

fun html(init: Html.() -> Unit): Html =
    Html().apply(init)
