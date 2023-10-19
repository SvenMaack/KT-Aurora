package lib.tags

import lib.base.Attribute
import lib.base.TagContainer

open class BodyTagContainer(name: String) : TagContainer(name) {
    inline fun p(vararg attributes: Attribute, clazz: String? = null, init: P.() -> Unit) = add(P()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun span(vararg attributes: Attribute, clazz: String? = null, init: Span.() -> Unit) = add(Span()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h1(vararg attributes: Attribute, clazz: String? = null, init: H1.() -> Unit) = add(H1()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h2(vararg attributes: Attribute, clazz: String? = null, init: H2.() -> Unit) = add(H2()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h3(vararg attributes: Attribute, clazz: String? = null, init: H3.() -> Unit) = add(H3()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h4(vararg attributes: Attribute, clazz: String? = null, init: H4.() -> Unit) = add(H4()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h5(vararg attributes: Attribute, clazz: String? = null, init: H5.() -> Unit) = add(H5()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun h6(vararg attributes: Attribute, clazz: String? = null, init: H6.() -> Unit) = add(H6()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun div(vararg attributes: Attribute, clazz: String? = null, init: Div.() -> Unit) = add(Div()) {
        if(clazz.isNullOrEmpty())
            setAttributes(*attributes)
        else
            setAttributes(*attributes, "class"[clazz])
        init()
    }
    inline fun br() = add(Br)
    inline fun hr() = add(Hr)
}
