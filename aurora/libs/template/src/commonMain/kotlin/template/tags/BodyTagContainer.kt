package template.tags

import template.base.Attribute
import template.base.get
import template.base.TagContainer
import template.base.AttributeImpl
import template.tags.enums.EncType
import template.tags.enums.Target
import template.tags.enums.Method
import template.tags.enums.MediaType
import template.tags.enums.Language
import template.tags.enums.Rel
import template.tags.enums.AutoComplete
import template.tags.enums.ReferrerPolicy

@Suppress("TooManyFunctions", "LargeClass")
public open class BodyTagContainer(name: String) : TagContainer(name) {
    /**
     * The a-tag defines a hyperlink, which is used to link from one page to another.
     * @param download Specifies that the target will be downloaded when a user clicks on the hyperlink
     * @param hrefLang Specifies the language of the linked document
     * @param pings Specifies a list of URLs to which, when the link is followed, post requests with the body ping will be sent by the browser (in the background). Typically used for tracking.
     * @param referrerPolicy Specifies which referrer information to send with the link
     * @param rel Specifies the relationship between the current document and the linked document
     * @param target Specifies where to open the linked document
     * @param type Specifies the media type of the linked document
     */
    @Suppress("LongParameterList", "SpreadOperator", "LongMethod")
    public inline fun a(
        vararg attributes: Attribute,
        href: String,
        type: MediaType? = null,
        download: Boolean = false,
        target: Target? = null,
        clazz: String? = null,
        hrefLang: Language? = null,
        referrerPolicy: ReferrerPolicy? = null,
        rel: Rel? = null,
        pings: List<String> = listOf(),
        init: A.() -> Unit): A = A.addATagWithAttributes(
            this,
            href,
            type,
            download,
            target,
            clazz,
            hrefLang,
            referrerPolicy,
            rel,
            pings,
            *attributes
        ).apply(init)

    /**
     * The address-tag defines contact information for the author/owner of a document or an article. The contact information can be an email address, URL, physical address, phone number, social media handle, etc.
     */
    public inline fun address(vararg attributes: Attribute, title: String? = null, init: Address.() -> Unit): Address = add(Address()) {
        if(title==null) setAttributes(*attributes) else setAttributes(*attributes, "title"[title])
        init()
    }

    /**
     * The article-tag specifies independent, self-contained content. An article should make sense on its own and it should be possible to distribute it independently from the rest of the site.
     */
    public inline fun article(vararg attributes: Attribute, clazz: String? = null, init: Article.() -> Unit): Article = add(Article()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The aside-tag defines some content aside from the content it is placed in. The aside content should be indirectly related to the surrounding content.
     */
    public inline fun aside(vararg attributes: Attribute, clazz: String? = null, init: Aside.() -> Unit): Aside = add(Aside()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The blockquote-tag specifies a section that is quoted from another source.
     */
    public inline fun blockQuote(vararg attributes: Attribute, cite: String, init: BlockQuote.() -> Unit): BlockQuote = add(BlockQuote()) {
        setAttributes(*attributes, "cite"[cite])
        init()
    }

    /**
     * The br-tag inserts a single line break.
     */
    @Deprecated("Use css instead", ReplaceWith("css"))
    public inline fun br(): Br = add(Br)

    /**
     * A description list, with terms and descriptions:
     */
    public inline fun dl(vararg attributes: Attribute, clazz: String? = null, init: Dl.() -> Unit): Dl = add(Dl()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * A description list, with terms and descriptions:
     */
    public inline fun details(open: Boolean, init: Details.() -> Unit): Details = add(Details()) {
        if(open)
            setAttributes(AttributeImpl("open"))
        init()
    }

    /**
     * The div-tag defines a division or a section in an HTML document.
     */
    public inline fun div(vararg attributes: Attribute, clazz: String? = null, init: Div.() -> Unit): Div = add(Div()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The footer-tag defines a footer for a document or section.
     */
    public inline fun footer(vararg attributes: Attribute, clazz: String? = null, init: Footer.() -> Unit): Footer = add(Footer()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The form-tag is used to create an HTML form for user input.
     */
    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun form(
        vararg attributes: Attribute,
        method: Method = Method.POST,
        name: String,
        id: String,
        action: String,
        acceptCharset: String? = null,
        autoComplete: AutoComplete? = null,
        encType: EncType? = null,
        noValidate: Boolean = false,
        rel: Rel? = null,
        target: Target? = null,
        clazz: String? = null,
        init: Form.() -> Unit): Form = add(Form(id))
    {
        setAttributes(
            *attributes,
            "name"[name],
            "method"[method.value],
            "id"[id],
            "action"[action],
            *AttributeFilter.filterTrue(
                BoolAttribute("novalidate", noValidate),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "accept-charset"[acceptCharset],
                "autocomplete"[autoComplete?.value],
                "enctype"[encType?.value],
                "rel"[rel?.value],
                "target"[target?.value],
            )
        )
        init()
    }

    /**
     * The h1- to h6-tags are used to define HTML headings.
     */
    public inline fun h1(vararg attributes: Attribute, clazz: String? = null, init: H1.() -> Unit): H1 = add(H1()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The h1- to h6-tags are used to define HTML headings.
     */
    public inline fun h2(vararg attributes: Attribute, clazz: String? = null, init: H2.() -> Unit): H2 = add(H2()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The h1- to h6-tags are used to define HTML headings.
     */
    public inline fun h3(vararg attributes: Attribute, clazz: String? = null, init: H3.() -> Unit): H3 = add(H3()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The h1- to h6-tags are used to define HTML headings.
     */
    public inline fun h4(vararg attributes: Attribute, clazz: String? = null, init: H4.() -> Unit): H4 = add(H4()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The h1- to h6-tags are used to define HTML headings.
     */
    public inline fun h5(vararg attributes: Attribute, clazz: String? = null, init: H5.() -> Unit): H5 = add(H5()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The h1- to h6-tags are used to define HTML headings.
     */
    public inline fun h6(vararg attributes: Attribute, clazz: String? = null, init: H6.() -> Unit): H6 = add(H6()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }

    /**
     * The hr-tag defines a thematic break in an HTML page (e.g. a shift of topic).
     */
    public inline fun hr(): Hr = add(Hr)

    /**
     * The iframe-tag specifies an inline frame.
     */
    @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
    public inline fun iFrame(
        vararg attributes: Attribute,
        src: String,
        height: Int,
        width: Int,
        name: String,
        loading: IFrameLoading = IFrameLoading.LAZY,
        allow: Boolean = false,
        allowFullScreen: Boolean = false,
        allowPaymentRequest: Boolean = false,
        referrerPolicy: ReferrerPolicy? = null,
        sandBox: MutableList<IFrameSandbox>? = null,
        clazz: String? = null,
        init: IFrame.() -> Unit): IFrame = add(IFrame())
    {
        if(sandBox?.contains(IFrameSandbox.All) == true) {
            sandBox.clear()
            sandBox.add(IFrameSandbox.All)
        }
        setAttributes(
            *attributes,
            "height"[height.toString()],
            "width"[width.toString()],
            "loading"[loading.value],
            "name"[name],
            "src"[src],
            *AttributeFilter.filterTrue(
                BoolAttribute("allow", allow),
                BoolAttribute("allowfullscreen", allowFullScreen),
                BoolAttribute("allowpaymentrequest", allowPaymentRequest),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "referrerpolicy"[referrerPolicy?.value],
                "sandbox"[sandBox?.joinToString(" ") { it.value }],
            )
        )
        init()
    }






    public inline fun main(vararg attributes: Attribute, clazz: String? = null, init: Main.() -> Unit): Main = add(Main()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun menu(vararg attributes: Attribute, clazz: String? = null, init: Menu.() -> Unit): Menu = add(Menu()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun nav(vararg attributes: Attribute, clazz: String? = null, init: Nav.() -> Unit): Nav = add(Nav()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun ol(vararg attributes: Attribute, clazz: String? = null, init: Ol.() -> Unit): Ol = add(Ol()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun p(vararg attributes: Attribute, clazz: String? = null, init: P.() -> Unit): P = add(P()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun search(init: Search.() -> Unit): Search = add(Search()) {
        init()
    }
    public inline fun section(vararg attributes: Attribute, clazz: String? = null, init: Section.() -> Unit): Section = add(Section()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun span(vararg attributes: Attribute, clazz: String? = null, init: Span.() -> Unit): Span = add(Span()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun template(vararg attributes: Attribute, clazz: String? = null, init: Template.() -> Unit): Template = add(Template()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
    public inline fun ul(vararg attributes: Attribute, clazz: String? = null, init: Ul.() -> Unit): Ul = add(Ul()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}
