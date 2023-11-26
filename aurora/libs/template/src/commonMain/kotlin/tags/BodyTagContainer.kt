package template_lib.tags

import template_lib.base.Attribute
import template_lib.base.get
import template_lib.base.TagContainer

public open class BodyTagContainer(name: String) : TagContainer(name) {
    public inline fun p(vararg attributes: Attribute, clazz: String? = null, init: P.() -> Unit): P = add(P()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun span(vararg attributes: Attribute, clazz: String? = null, init: Span.() -> Unit): Span = add(Span()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun address(vararg attributes: Attribute, title: String? = null, init: Address.() -> Unit): Address = add(Address()) {
        if(title==null) setAttributes(*attributes) else setAttributes(*attributes, "title"[title])
        init()
    }

    public inline fun h1(vararg attributes: Attribute, clazz: String? = null, init: H1.() -> Unit): H1 = add(H1()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun h2(vararg attributes: Attribute, clazz: String? = null, init: H2.() -> Unit): H2 = add(H2()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun h3(vararg attributes: Attribute, clazz: String? = null, init: H3.() -> Unit): H3 = add(H3()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun h4(vararg attributes: Attribute, clazz: String? = null, init: H4.() -> Unit): H4 = add(H4()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun h5(vararg attributes: Attribute, clazz: String? = null, init: H5.() -> Unit): H5 = add(H5()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun h6(vararg attributes: Attribute, clazz: String? = null, init: H6.() -> Unit): H6 = add(H6()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    public inline fun div(vararg attributes: Attribute, clazz: String? = null, init: Div.() -> Unit): Div = add(Div()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun nav(vararg attributes: Attribute, clazz: String? = null, init: Nav.() -> Unit): Nav = add(Nav()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    public inline fun ul(vararg attributes: Attribute, clazz: String? = null, init: Ul.() -> Unit): Ul = add(Ul()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun ol(vararg attributes: Attribute, clazz: String? = null, init: Ol.() -> Unit): Ol = add(Ol()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    public inline fun a(
        href: String,
        clazz: String? = null,
        init: A.() -> Unit): A = add(A()
    ) {
        if(clazz==null) setAttributes("href"[href]) else setAttributes("href"[href], "class"[clazz])
        init()
    }

    /**
     * @param download Specifies that the target will be downloaded when a user clicks on the hyperlink
     * @param hrefLang Specifies the language of the linked document
     * @param pings 	Specifies a list of URLs to which, when the link is followed, post requests with the body ping will be sent by the browser (in the background). Typically used for tracking.
     * @param referrerPolicy Specifies which referrer information to send with the link
     * @param rel Specifies the relationship between the current document and the linked document
     * @param target Specifies where to open the linked document
     * @param type Specifies the media type of the linked document
     */
    public inline fun a(
        href: String,
        type: MediaType,
        download: Boolean,
        target: Target = Target.SELF,
        clazz: String? = null,
        hrefLang: String? = null,
        referrerPolicy: ReferrerPolicy? = null,
        rel: Rel? = null,
        pings: List<String> = listOf(),
        init: A.() -> Unit): A = add(A(),
    ) {
        val attributes = mutableListOf(
            "href"[href],
            "type"[type.value],
            "target"[target.value]
        )
        if(download)
            attributes.add(object : Attribute {
                override val name: String = "download"
                override val value: String? = null
            })
        if(clazz != null)
            attributes.add("class"[clazz])
        if(hrefLang != null)
            attributes.add("hreflang"[hrefLang])
        if(referrerPolicy != null)
            attributes.add("referrerpolicy"[referrerPolicy.value])
        if(rel != null)
            attributes.add("rel"[rel.value])
        if(pings.isNotEmpty())
            attributes.add("ping"[pings.joinToString(" ")])

        setAttributes(*attributes.toTypedArray())
        init()
    }

    public inline fun br(): Br = add(Br)
    public inline fun hr(): Hr = add(Hr)
}
