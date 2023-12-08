package css.base

public enum class SelectorType {
    CLASS,
    ID,
    UNIVERSAL,
    TAG,
    PSEUDO,
    /*
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

public enum class PseudoValues(public val value: String) {
    AFTER("after"),
    BEFORE("before"),
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

public class Pseudo(private val selector: Selector, private val pseudo: PseudoValues): Selector {
    override fun getType(): SelectorType = SelectorType.PSEUDO
    public override fun toString(): String = "$selector:${pseudo.value}"
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
