package css.base

public interface IRule {
    public val properties: List<Property>

    public val selector: Selector
    public fun getClass(): String?
}

public data class Rule(public override val selector: Selector): IRule {
    override val properties: MutableList<Property> = mutableListOf()

    public constructor(classSelector: String): this(Class(classSelector))

    public override fun getClass(): String? =
        if (selector is Class) selector.name else null

    public operator fun Property.unaryPlus(): Property {
        properties.add(this)
        return this
    }
}

public inline infix fun Selector.rule(init: Rule.() -> Unit): Rule =
    Rule(this).apply(init)

public inline infix fun String.rule(init: Rule.() -> Unit): Rule =
    Class(this).rule(init)
