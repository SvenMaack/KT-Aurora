package css_lib.base

class Document {
    internal val rules: MutableList<Rule> = mutableListOf()

    operator fun set(vararg selector: String, init: Rule.() -> Unit) {
        selector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
    }

    fun traverse(visitor: Visitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }
}
