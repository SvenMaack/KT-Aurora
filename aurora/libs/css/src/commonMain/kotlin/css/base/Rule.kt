package css.base

public data class Rule(internal val classSelector: String) {
    private var _properties : MutableList<Property> = mutableListOf()
    internal val properties: List<Property> = _properties

    public fun getClass(): String = classSelector

    public operator fun Property.unaryPlus(): Property {
        _properties.add(this)
        return this
    }
}

public inline infix fun String.rule(init: Rule.() -> Unit): Rule =
    Rule(this).apply(init)
