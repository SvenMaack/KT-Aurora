@file:Suppress("unused")

package template_lib.tags

import template_lib.base.TagContainer
import template_lib.base.Visitor
import template_lib.base.get
import template_lib.tags.enums.Language

public enum class Direction(public val shortCode: String) {
    RTL("rtl"),
    LTR("ltr")
}

public class Html: TagContainer("html") {
    public inline fun head(init: Head.() -> Unit): Head = add(Head(), init)
    public inline fun body(init: Body.() -> Unit): Body = add(Body(), init)

    override fun traverse(visitor: Visitor<*>) {
        DocType.traverse(visitor)
        super.traverse(visitor)
    }
}

public fun html(
    lang: Language,
    dir: Direction = Direction.LTR,
    xmlns: String? = null,
    init: Html.() -> Unit
): Html =
    Html().apply {
        init()
        if(xmlns == null)
            setAttributes("lang"[lang.value], "dir"[dir.shortCode])
        else
            setAttributes("lang"[lang.value], "dir"[dir.shortCode], "xmlns"[xmlns])
    }
