package css_lib.base

interface IDocument {
    fun traverse(visitor: RuleVisitor<*>)
}

open class Document: IDocument {
    internal val rules : MutableList<Rule> = mutableListOf()

    operator fun set(vararg classSelector: String, init: Rule.() -> Unit) {
        classSelector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
    }

    fun set(rule: Rule) {
        rules.add(rule)
    }

    override fun traverse(visitor: RuleVisitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }

    fun getRuleAmount(): Int =
        rules.size

    fun getRules(): List<Rule> =
        rules
}

val EmptyDocument: IDocument = Document()
