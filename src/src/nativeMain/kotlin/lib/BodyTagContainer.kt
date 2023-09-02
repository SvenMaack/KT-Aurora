package lib

import lib.base.Attribute
import lib.base.TagContainer

open class BodyTagContainer(name: String) : TagContainer(name) {
    inline fun p(vararg attributes: Attribute, init: P.() -> Unit) = add(P()) {
        setAttributes(attributes)
        init()
    }
    inline fun h1(vararg attributes: Attribute, init: H1.() -> Unit) = add(H1()) {
        setAttributes(attributes)
        init()
    }
    inline fun h2(vararg attributes: Attribute, init: H2.() -> Unit) = add(H2()) {
        setAttributes(attributes)
        init()
    }
    inline fun h3(vararg attributes: Attribute, init: H3.() -> Unit) = add(H3()) {
        setAttributes(attributes)
        init()
    }
    inline fun h4(vararg attributes: Attribute, init: H4.() -> Unit) = add(H4()) {
        setAttributes(attributes)
        init()
    }
    inline fun h5(vararg attributes: Attribute, init: H5.() -> Unit) = add(H5()) {
        setAttributes(attributes)
        init()
    }
    inline fun h6(vararg attributes: Attribute, init: H6.() -> Unit) = add(H6()) {
        setAttributes(attributes)
        init()
    }
    inline fun div(vararg attributes: Attribute, init: Div.() -> Unit) = add(Div()) {
        setAttributes(attributes)
        init()
    }
    inline fun br(vararg attributes: Attribute) = add(Br) {
        setAttributes(attributes)
    }
}
