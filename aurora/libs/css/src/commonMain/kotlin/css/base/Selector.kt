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

internal enum class PseudoValues(val value: String) {
    AFTER("after"),
    BEFORE("before"),
    HOVER("hover"),
    FOCUS_WITHIN("focus-within"),
}

public interface Selector {
    public fun getType(): SelectorType
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

internal class Pseudo(private val selector: Selector, private val pseudo: PseudoValues): Selector {
    override fun getType(): SelectorType = SelectorType.PSEUDO
    override fun toString(): String = "$selector:${pseudo.value}"
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
