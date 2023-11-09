package css_lib.base

open class Rule(internal val classSelector: String) {
    private var _properties : MutableList<Property> = mutableListOf()
    internal val properties: List<Property> = _properties

    open fun getClass(): String = classSelector

    open operator fun Property.unaryPlus(): Property {
        _properties.add(this)
        return this
    }
}

inline infix fun String.rule(init: Rule.() -> Unit): Rule =
    Rule(this).apply(init)
