package template_lib.tags

import template_lib.base.Attribute
import template_lib.base.TagContainer
import template_lib.base.get

public class Details: TagContainer("details") {
    public inline fun summary(vararg attributes: Attribute, clazz: String? = null, init: Summary.() -> Unit): Summary = add(Summary()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

public class Summary: TextContainer("summary")
