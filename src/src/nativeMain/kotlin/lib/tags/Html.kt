package lib.tags

import lib.tags.base.TagContainer
import lib.tags.base.Visitor

enum class Direction(val shortCode: String) {
    RTL("rtl"),
    LTR("ltr")
}

class Html: TagContainer("html") {
    inline fun body(init: Body.() -> Unit) = add(Body(), init)
    inline fun head(init: Head.() -> Unit) = add(Head(), init)

    override fun traverse(visitor: Visitor) {
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
