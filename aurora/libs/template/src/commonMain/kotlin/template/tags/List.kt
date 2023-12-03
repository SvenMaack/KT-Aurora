package template.tags

import template.base.Attribute
import template.base.get

/**
 * The ul-tag defines an unordered (bulleted) list.
 */
public class Ul: BodyTagContainer("ul") {
    /**
     * The li-tag defines a list item.
     */
    public inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

/**
 * The ol-tag defines an ordered list. An ordered list can be numerical or alphabetical.
 */
public class Ol: BodyTagContainer("ol") {
    /**
     * The li-tag defines a list item.
     */
    public inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

/**
 * The menu-tag defines an unordered list of content. an alternative to the ul-tag and browsers will treat these two lists equally.
 */
public class Menu: BodyTagContainer("menu") {
    public inline fun li(vararg attributes: Attribute, clazz: String? = null, init: Li.() -> Unit): Li = add(Li()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

/**
 * The li-tag defines a list item.
 */
public class Li: BodyTagContainer("li")
