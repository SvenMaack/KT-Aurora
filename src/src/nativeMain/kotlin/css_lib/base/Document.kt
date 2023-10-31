package css_lib.base

open class Document {
    internal val rules: MutableList<Rule> = mutableListOf()

    operator fun set(vararg selector: String, init: Rule.() -> Unit) {
        selector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
    }

    open fun traverse(visitor: Visitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }
}
