package template.tags

import kotlinx.datetime.LocalDateTime
import template.base.Attribute
import template.base.TagWithText
import template.base.get
import template.tags.enums.MediaType
import template.tags.enums.Language
import template.tags.enums.ReferrerPolicy
import template.tags.enums.Rel
import template.tags.enums.Target

@Suppress("TooManyFunctions")
public open class TextContainer(name: String): TagWithText(name) {
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
    @Suppress("LongParameterList", "SpreadOperator")
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
     * The abbr-tag defines an abbreviation or an acronym, like "HTML", "CSS", "Mr.", "Dr.", "ASAP", "ATM".
     */
    public inline fun abbr(title: String, init: Abbr.() -> Unit): Abbr = add(Abbr()) {
        setAttributes("title"[title])
        init()
    }

    /**
     * The cite-tag defines the title of a creative work (e.g. a book, a poem, a song, a movie, a painting, a sculpture, etc.).
     */
    public inline fun cite(init: Cite.() -> Unit): Cite = add(Cite()) {
        init()
    }

    /**
     * The code-tag is used to define a piece of computer code. The content inside is displayed in the browser's default monospace font.
     */
    public inline fun code(init: Code.() -> Unit): Code = add(Code()) {
        init()
    }




    /**
     * The tag is used to add a machine-readable translation of a given content.
     */
    public inline fun data(init: Data.() -> Unit): Data = add(Data()) {
        init()
    }

    /**
     * The tag stands for the "definition element", and it specifies a term that is going to be defined within the content.
     */
    public inline fun dfn(init: Dfn.() -> Unit): Dfn = add(Dfn()) {
        init()
    }

    /**
     * The tag defines text that should be marked or highlighted.
     */
    public inline fun mark(init: Mark.() -> Unit): Mark = add(Mark()) {
        init()
    }

    /**
     * The tag is used to represent the result of a calculation (like one performed by a script).
     */
    public inline fun output(init: Output.() -> Unit): Output = add(Output()) {
        init()
    }

    /**
     * The tag is used to define emphasized text. The content inside is typically displayed in italic. A screen reader will pronounce the words in em with an emphasis, using verbal stress.
     */
    public inline fun em(init: Em.() -> Unit): Em = add(Em()) {
        init()
    }

    /**
     * The tag defines preformatted text.
     */
    public inline fun pre(init: Pre.() -> Unit): Pre = add(Pre()) {
        init()
    }

    /**
     * The tag defines subscript text. Subscript text appears half a character below the normal line, and is sometimes rendered in a smaller font. Subscript text can be used for chemical formulas, like H2O.
     */
    public inline fun sub(init: Sub.() -> Unit): Sub = add(Sub()) {
        init()
    }

    /**
     * The tag defines superscript text. Superscript text appears half a character above the normal line, and is sometimes rendered in a smaller font. Superscript text can be used for footnotes, like WWW[1].
     */
    public inline fun sup(init: Sup.() -> Unit): Sup = add(Sup()) {
        init()
    }

    /**
     * The tag is used to defines a variable in programming or in a mathematical expression. The content inside is typically displayed in italic.
     */
    @Suppress("FunctionNaming")
    public inline fun `var`(init: Var.() -> Unit): Var = add(Var()) {
        init()
    }

    /**
     * The tag defines a specific time (or datetime).
     */
    public inline fun time(dateTime: LocalDateTime? = null, init: Time.() -> Unit): Time = add(Time()) {
        if(dateTime != null)
            setAttributes("datetime"[dateTime.toString()])
        init()
    }

    /**
     * The (Word Break Opportunity) tag specifies where in a text it would be ok to add a line-break.
     */
    public inline fun wbr(): Wbr = add(Wbr)
}
