package template.tags

import template.base.TagContainer
import template.base.TemplatingApi
import template.base.get
import template.tags.enums.Target

/**
 * The head-element is a container for metadata (data about data) and is placed between the html-tag and the body-tag.
 */
@OptIn(TemplatingApi::class)
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

    /**
     * The link-tag defines the relationship between the current document and an external resource.
     */
    public inline fun link(rel: String, href: String): Link = add(Link()) {
        setAttributes("rel"[rel], "href"[href])
    }

    /**
     * The meta-tag defines metadata about an HTML document. Metadata is data (information) about data.
     */
    public inline fun meta(name: String, content: String): Meta = add(Meta()) {
        setAttributes("name"[name], "content"[content])
    }

    /**
     * The meta-tag defines metadata about an HTML document. Metadata is data (information) about data.
     */
    public inline fun meta(charset: String): Meta = add(Meta()) {
        setAttributes("charset"[charset])
    }

    /**
     * The style-tag is used to define style information (CSS) for a document.
     */
    public inline fun style(init: Style.() -> Unit): Style = add(Style(), init)

    /**
     * The title-tag defines the title of the document. The title must be text-only, and it is shown in the browser's title bar or in the page's tab.
     */
    public inline fun title(init: Title.() -> Unit): Title = add(Title(), init)
}
