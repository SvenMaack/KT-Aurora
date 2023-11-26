package template_lib.tags

import template_lib.base.Attribute
import template_lib.base.TagContainer
import template_lib.base.get

public class Article: TagContainer("article") {
    public inline fun header(vararg attributes: Attribute, clazz: String? = null, init: Header.() -> Unit): Header = add(Header()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}
