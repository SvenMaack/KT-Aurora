package template_lib.tags

import template_lib.base.AttributeImpl
import template_lib.base.TagWithText
import template_lib.base.get

public open class TextContainer(name: String): TagWithText(name) {
    public inline fun abbr(title: String, init: Abbr.() -> Unit): Abbr = add(Abbr()) {
        setAttributes("title"[title])
        init()
    }

    public inline fun cite(init: Cite.() -> Unit): Cite = add(Cite()) {
        init()
    }

    public inline fun code(init: Code.() -> Unit): Code = add(Code()) {
        init()
    }

    public inline fun data(init: Data.() -> Unit): Data = add(Data()) {
        init()
    }

    public inline fun details(open: Boolean, init: Details.() -> Unit): Details = add(Details()) {
        if(open)
            setAttributes(AttributeImpl("open"))
        init()
    }
}