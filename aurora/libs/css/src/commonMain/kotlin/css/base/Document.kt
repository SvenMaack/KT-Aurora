package css.base

public interface IDocument {
    public fun traverse(visitor: RuleVisitor<*>)
}

public open class Document: IDocument {
    internal val rules : MutableList<Rule> = mutableListOf()

    public operator fun set(vararg classSelector: String, init: Rule.() -> Unit) {
        classSelector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
    }

    public fun set(rule: Rule) {
        rules.add(rule)
    }

    override fun traverse(visitor: RuleVisitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }

    public fun getRuleAmount(): Int =
        rules.size

    public fun getRules(): List<Rule> =
        rules
}

public val EmptyDocument: IDocument = Document()
