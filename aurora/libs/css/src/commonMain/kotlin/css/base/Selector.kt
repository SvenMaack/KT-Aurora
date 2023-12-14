package css.base

public enum class SelectorType {
    CLASS,
    ID,
    UNIVERSAL,
    TAG,
    PSEUDO,
    COMBINATOR,
    ATTRIBUTE,
    /*
    COMBINATOR,
    NESTED,
    CHILD,
    DESCENDANT,
    SIBLING,
    ADJACENT_SIBLING,*/
    UNKNOWN
}

public enum class PseudoValues(public val value: String) {
    AFTER("after"),
    BEFORE("before"),
    HOVER("hover"),
    FOCUS_WITHIN("focus-within"),
}

public interface Selector {
    public fun getType(): SelectorType
}

/**
 * *
 */
public object UNIVERSAL: Selector {
    override fun getType(): SelectorType = SelectorType.UNIVERSAL
    public override fun toString(): String = "*"
}

public class Attribute(private val selector: Selector, private val attribute: String, private val value: String? = null): Selector {
    public constructor(clazz: String, attribute: String, value: String? = null):
            this(Class(clazz), attribute, value)

    override fun getType(): SelectorType = SelectorType.ATTRIBUTE
    public override fun toString(): String =
        if(value.isNullOrEmpty())
            "$selector[$attribute]"
        else
            "$selector[$attribute='$value']"
}

public class Pseudo(private val selector: Selector, private val pseudo: PseudoValues): Selector {
    override fun getType(): SelectorType = SelectorType.PSEUDO
    public override fun toString(): String = "$selector:${pseudo.value}"
}

public class CombinedSelector(private vararg val selector: Selector): Selector {
    override fun getType(): SelectorType = SelectorType.COMBINATOR
    public override fun toString(): String = selector.joinToString(",")
}

public class Class(public val name: String): Selector {
    override fun getType(): SelectorType = SelectorType.CLASS
    public override fun toString(): String = ".${cleanSelector(name)}"
}

public class Id(public val name: String): Selector {
    override fun getType(): SelectorType = SelectorType.ID
    public override fun toString(): String = "#${cleanSelector(name)}"
}

public class Tag(public val name: String): Selector {
    override fun getType(): SelectorType = SelectorType.TAG
    public override fun toString(): String = cleanSelector(name)
}

private fun cleanSelector(selector: String): String =
    selector
        .replace(" ", "")
        .replace(".", "")
        .replace(",", "")
        .replace(">", "")
        .replace("+", "")
        .replace("~", "")

public operator fun Selector.rangeTo(pseudo: PseudoValues): Selector =
    Pseudo(this, pseudo)

public val html: Tag = Tag("html")
public val body: Tag = Tag("body")
public val h1: Tag = Tag("h1")
public val h2: Tag = Tag("h2")
public val h3: Tag = Tag("h3")
public val h4: Tag = Tag("h3")
public val h5: Tag = Tag("h3")
public val p: Tag = Tag("p")
public val a: Tag = Tag("a")
public val figure: Tag = Tag("figure")
public val blockquote: Tag = Tag("blockquote")
public val dl: Tag = Tag("dl")
public val dd: Tag = Tag("dd")
public val img: Tag = Tag("img")
public val picture: Tag = Tag("picture")
public val input: Tag = Tag("input")
public val button: Tag = Tag("button")
public val textarea: Tag = Tag("textarea")
public val select: Tag = Tag("select")
