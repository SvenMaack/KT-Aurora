package template_lib.tags

import template_lib.base.Attribute
import template_lib.base.TagContainer
import template_lib.base.get

public class Dt: TagContainer("dt")

public class Dd: TagContainer("dd")

public class Dl: TagContainer("dl") {
    public inline fun dt(vararg attributes: Attribute, clazz: String? = null, init: Dt.() -> Unit): Dt = add(Dt()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    public inline fun dd(vararg attributes: Attribute, clazz: String? = null, init: Dd.() -> Unit): Dd = add(Dd()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}
