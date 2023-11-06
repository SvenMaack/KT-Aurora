package template_lib.tags

import template_lib.base.Attribute
import template_lib.base.get
import template_lib.base.TagContainer

open class BodyTagContainer(name: String) : TagContainer(name) {
    inline fun p(vararg attributes: Attribute, clazz: String? = null, init: P.() -> Unit): P = add(P()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun span(vararg attributes: Attribute, clazz: String? = null, init: Span.() -> Unit): Span = add(Span()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h1(vararg attributes: Attribute, clazz: String? = null, init: H1.() -> Unit): H1 = add(H1()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h2(vararg attributes: Attribute, clazz: String? = null, init: H2.() -> Unit): H2 = add(H2()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h3(vararg attributes: Attribute, clazz: String? = null, init: H3.() -> Unit): H3 = add(H3()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h4(vararg attributes: Attribute, clazz: String? = null, init: H4.() -> Unit): H4 = add(H4()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h5(vararg attributes: Attribute, clazz: String? = null, init: H5.() -> Unit): H5 = add(H5()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h6(vararg attributes: Attribute, clazz: String? = null, init: H6.() -> Unit): H6 = add(H6()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun div(vararg attributes: Attribute, clazz: String? = null, init: Div.() -> Unit): Div = add(Div()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun nav(vararg attributes: Attribute, clazz: String? = null, init: Nav.() -> Unit): Nav = add(Nav()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun ul(vararg attributes: Attribute, clazz: String? = null, init: Ul.() -> Unit): Ul = add(Ul()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun ol(vararg attributes: Attribute, clazz: String? = null, init: Ol.() -> Unit): Ol = add(Ol()) {
        setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun br(): Br = add(Br)
    inline fun hr(): Hr = add(Hr)
}
