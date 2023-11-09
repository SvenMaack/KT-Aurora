package css_lib.base

interface IDocument {
    fun traverse(visitor: RuleVisitor<*>)
}

open class Document: IDocument {
    internal val rules : MutableList<Rule> = mutableListOf()

    operator fun set(vararg selector: String, init: Rule.() -> Unit) {
        selector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
    }

    override fun traverse(visitor: RuleVisitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }
}
