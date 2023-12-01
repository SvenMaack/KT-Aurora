package template.tags

import template.base.Attribute
import template.base.get

public class Ul: BodyTagContainer("ul") {
    public inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

public class Ol: BodyTagContainer("ol") {
    public inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

public class Menu: BodyTagContainer("menu") {
    public inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

public class Li: BodyTagContainer("li")
