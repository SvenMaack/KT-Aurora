package template_lib.tags

import template_lib.base.Attribute
import template_lib.base.get

class Ul: BodyTagContainer("ul") {
    inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
}

class Ol: BodyTagContainer("ol") {
    inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
}

class Li: BodyTagContainer("li")
