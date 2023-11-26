package template_lib.tags

import template_lib.base.TagWithText
import template_lib.base.get

public open class TextContainer(name: String): TagWithText(name) {
    public inline fun abbr(title: String, init: Abbr.() -> Unit): Abbr = add(Abbr()) {
        setAttributes("title"[title])
        init()
    }
}