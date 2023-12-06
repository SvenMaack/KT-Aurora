package template.tags

import template.base.TagContainer
import template.base.HtmlVisitor
import template.base.TemplatingApi
import template.base.get
import template.tags.enums.Language

public enum class Direction(public val shortCode: String) {
    RTL("rtl"),
    LTR("ltr")
}

/**
 * The html-tag represents the root of an HTML document.
 */
@OptIn(TemplatingApi::class)
public class Html: TagContainer("html") {
    /**
     * The head-element is a container for metadata (data about data) and is placed between the html-tag and the body-tag.
     */
    public inline fun head(init: Head.() -> Unit): Head = add(Head(), init)

    /**
     * The body-tag defines the document's body. The body-element contains all the contents of an HTML document, such as headings, paragraphs, images, hyperlinks, tables, lists, etc.
     */
    public inline fun body(init: Body.() -> Unit): Body = add(Body(), init)

    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        DocType.traverse(htmlVisitor)
        super.traverse(htmlVisitor)
    }
}

/**
 * The html-tag represents the root of an HTML document.
 */
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
