@file:Suppress("unused")

package template.tags

import template.base.TagContainer
import template.base.HtmlVisitor
import template.base.get
import template.tags.enums.Language

public enum class Direction(public val shortCode: String) {
    RTL("rtl"),
    LTR("ltr")
}

public class Html: TagContainer("html") {
    public inline fun head(init: Head.() -> Unit): Head = add(Head(), init)
    public inline fun body(init: Body.() -> Unit): Body = add(Body(), init)

    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        DocType.traverse(htmlVisitor)
        super.traverse(htmlVisitor)
    }
}

@Suppress("LongParameterList")
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
