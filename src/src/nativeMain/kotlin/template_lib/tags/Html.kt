@file:Suppress("unused")

package template_lib.tags

import template_lib.base.TagContainer
import template_lib.base.Visitor
import template_lib.base.get

enum class Direction(val shortCode: String) {
    RTL("rtl"),
    LTR("ltr")
}

class Html: TagContainer("html") {
    inline fun head(init: Head.() -> Unit) = add(Head(), init)
    inline fun body(init: Body.() -> Unit) = add(Body(), init)

    override fun traverse(visitor: Visitor<*>) {
        DocType.traverse(visitor)
        super.traverse(visitor)
    }
}

fun html(
    lang: String = "",
    dir: Direction = Direction.LTR,
    init: Html.() -> Unit
): Html =
    Html().apply {
        init()
        setAttributes("lang"[lang], "dir"[dir.shortCode])
    }
