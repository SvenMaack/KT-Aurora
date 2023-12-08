package css.base

public enum class SelectorType {
    CLASS,
    ID,
    UNIVERSAL,
    TAG,/*
    PSEUDO_CLASS,
    PSEUDO_ELEMENT,
    ATTRIBUTE,
    COMBINATOR,
    NESTED,
    CHILD,
    DESCENDANT,
    SIBLING,
    ADJACENT_SIBLING,*/
    UNKNOWN
}

public interface Selector {
    public fun getType(): SelectorType
    public fun asString(): String
}

/**
 * *
 */
public object UNIVERSAL: Selector {
    override fun getType(): SelectorType = SelectorType.UNIVERSAL
    override fun asString(): String = "*"
    public override fun toString(): String = asString()
}

public class Class(public val name: String): Selector {
    override fun getType(): SelectorType = SelectorType.CLASS
    override fun asString(): String = ".${cleanSelector(name)}"
    public override fun toString(): String = asString()
}

public class Id(public val name: String): Selector {
    override fun getType(): SelectorType = SelectorType.ID
    override fun asString(): String = "#${cleanSelector(name)}"
    public override fun toString(): String = asString()
}

public class Tag(public val name: String): Selector {
    override fun getType(): SelectorType = SelectorType.TAG
    override fun asString(): String = cleanSelector(name)
    public override fun toString(): String = asString()
}

private fun cleanSelector(selector: String): String =
    selector
        .replace(" ", "")
        .replace(".", "")
        .replace(",", "")
        .replace(">", "")
        .replace("+", "")
        .replace("~", "")
