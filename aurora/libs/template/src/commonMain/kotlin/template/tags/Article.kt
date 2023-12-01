package template.tags

import template.base.Attribute
import template.base.TagContainer
import template.base.get

public class Article: TagContainer("article") {
    public inline fun header(vararg attributes: Attribute, clazz: String? = null, init: Header.() -> Unit): Header = add(Header()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}
