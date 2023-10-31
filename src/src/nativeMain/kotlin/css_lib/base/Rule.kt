package css_lib.base

open class Rule(
    val selector: String,
    val properties: MutableList<Property> = mutableListOf()
) {
    open operator fun Property.unaryPlus(): Property {
        properties.add(this)
        return this
    }
}

inline infix fun String.rule(init: Rule.() -> Unit): Rule =
    Rule(this).apply(init)
