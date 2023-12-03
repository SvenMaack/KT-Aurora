package template.tags

import template.base.TagContainer
import template.base.get
import template.tags.enums.Target

/**
 * The head-element is a container for metadata (data about data) and is placed between the html-tag and the body-tag.
 */
public class Head: TagContainer("head") {
    /**
     * The base-tag specifies the base URL and/or target for all relative URLs in a document. The base-tag must have either an href or a target attribute present, or both.
     */
    public inline fun base(href: String, target: Target): Base = add(Base()) {
        setAttributes("href"[href], "target"[target.value])
    }
    /**
     * The base-tag specifies the base URL and/or target for all relative URLs in a document. The base-tag must have either an href or a target attribute present, or both.
     */
    public inline fun base(href: String): Base = add(Base()) {
        setAttributes("href"[href])
    }
    /**
     * The base-tag specifies the base URL and/or target for all relative URLs in a document. The base-tag must have either an href or a target attribute present, or both.
     */
    public inline fun base(target: Target): Base = add(Base()) {
        setAttributes("target"[target.value])
    }

    public inline fun link(rel: String, href: String): Link = add(Link()) {
        setAttributes("rel"[rel], "href"[href])
    }

    public inline fun meta(name: String, content: String): Meta = add(Meta()) {
        setAttributes("name"[name], "content"[content])
    }

    public inline fun meta(charset: String): Meta = add(Meta()) {
        setAttributes("charset"[charset])
    }

    public inline fun style(init: Style.() -> Unit): Style = add(Style(), init)

    public inline fun title(init: Title.() -> Unit): Title = add(Title(), init)
}
