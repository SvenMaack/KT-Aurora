package lib.tags

import lib.base.Attribute
import lib.base.get
import lib.base.TagContainer

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
    inline fun br(): Br = add(Br)
    inline fun hr(): Hr = add(Hr)
}
