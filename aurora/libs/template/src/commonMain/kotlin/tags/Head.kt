package template_lib.tags

import template_lib.base.TagContainer
import template_lib.base.get

public class Head: TagContainer("head") {
    public inline fun title(init: Title.() -> Unit): Title = add(Title(), init)

    public inline fun style(init: Style.() -> Unit): Style = add(Style(), init)

    public inline fun meta(
        name: String,
        content: String,
    ): Meta = add(Meta()) {
        setAttributes("name"[name], "content"[content])
    }

    public inline fun meta(
        charset: String
    ): Meta = add(Meta()) {
        setAttributes("charset"[charset])
    }

    public inline fun link(
        rel: String,
        href: String,
    ): Link = add(Link()) {
        setAttributes("rel"[rel], "href"[href])
    }
}
