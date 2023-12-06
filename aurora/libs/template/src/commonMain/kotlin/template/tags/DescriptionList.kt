package template.tags

import template.base.Attribute
import template.base.TagContainer
import template.base.TemplatingApi
import template.base.get

/**
 * The dt tag defines a term/name in a description list.
 */
public class Dt: TagContainer("dt")

/**
 * The dd-tag is used to describe a term/name in a description list.
 */
public class Dd: TagContainer("dd")

/**
 * A description list, with terms and descriptions:
 */
@OptIn(TemplatingApi::class)
public class Dl: TagContainer("dl") {
    /**
     * The dt tag defines a term/name in a description list.
     */
    public inline fun dt(vararg attributes: Attribute, clazz: String? = null, init: Dt.() -> Unit): Dt = add(Dt()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The dd-tag is used to describe a term/name in a description list.
     */
    public inline fun dd(vararg attributes: Attribute, clazz: String? = null, init: Dd.() -> Unit): Dd = add(Dd()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}
