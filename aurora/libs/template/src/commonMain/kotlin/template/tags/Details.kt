package template.tags

import template.base.Attribute
import template.base.TagContainer
import template.base.get

public class Details: TagContainer("details") {
    public inline fun summary(vararg attributes: Attribute, clazz: String? = null, init: Summary.() -> Unit): Summary = add(Summary()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

public class Summary: TextContainer("summary")
