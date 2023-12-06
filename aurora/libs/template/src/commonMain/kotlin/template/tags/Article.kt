package template.tags

import template.base.Attribute
import template.base.TemplatingApi
import template.base.get

/**
 * The article-tag specifies independent, self-contained content. An article should make sense on its own and it should be possible to distribute it independently from the rest of the site.
 */
@OptIn(TemplatingApi::class)
public class Article: BodyTagContainer("article") {
    /**
     * The header-element represents a container for introductory content or a set of navigational links.
     */
    public inline fun header(vararg attributes: Attribute, clazz: String? = null, init: Header.() -> Unit): Header = add(Header()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}
