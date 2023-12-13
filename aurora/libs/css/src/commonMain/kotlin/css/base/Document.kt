package css.base

public interface IDocument {
    public fun traverse(visitor: RuleVisitor<*>)
    public fun gatherDocuments(set: MutableSet<IDocument>)
}

public open class Document: IDocument {
    internal val rules : MutableList<IRule> = mutableListOf()

    public operator fun set(vararg selectors: Selector, init: Rule.() -> Unit) {
        if(selectors.size == 1)
            rules.add(Rule(selectors[0]).apply(init))
        else if(selectors.size > 1)
            rules.add(
                Rule(CombinedSelector(*selectors)).apply(init)
            )
    }

    public operator fun set(vararg selector: String, init: Rule.() -> Unit) {
        selector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
    }

    public operator fun Rule.unaryPlus() {
        rules.add(this)
    }

    override fun traverse(visitor: RuleVisitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }

    override fun gatherDocuments(set: MutableSet<IDocument>) {
        set.add(this)
    }
}

public val EmptyDocument: IDocument = Document()
