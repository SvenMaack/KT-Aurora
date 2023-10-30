package css_lib.base

data class Rule(
    val selector: String,
    val properties: MutableList<Property> = mutableListOf()
) {
    fun add(property: Property): Rule {
        properties.add(property)
        return this
    }
}

inline infix fun String.rule(init: Rule.() -> Unit): Rule =
    Rule(this).apply(init)
