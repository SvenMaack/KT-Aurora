package template.tags

import kotlinx.datetime.LocalDateTime
import template.base.TagWithText
import template.base.get

@Suppress("TooManyFunctions")
public open class TextContainer(name: String): TagWithText(name) {
    /**
     * The tag defines an abbreviation or an acronym, like "HTML", "CSS", "Mr.", "Dr.", "ASAP", "ATM".
     */
    public inline fun abbr(title: String, init: Abbr.() -> Unit): Abbr = add(Abbr()) {
        setAttributes("title"[title])
        init()
    }

    /**
     * The tag defines the title of a creative work (e.g. a book, a poem, a song, a movie, a painting, a sculpture, etc.).
     */
    public inline fun cite(init: Cite.() -> Unit): Cite = add(Cite()) {
        init()
    }

    /**
     * The tag is used to define a piece of computer code. The content inside is displayed in the browser's default monospace font.
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
