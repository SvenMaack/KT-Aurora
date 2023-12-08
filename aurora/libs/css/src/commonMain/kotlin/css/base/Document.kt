package css.base

public interface IDocument {
    public fun traverse(visitor: RuleVisitor<*>)
}

public open class Document: IDocument {
    internal val rules : MutableList<IRule> = mutableListOf()

    public operator fun set(vararg selector: Selector, init: Rule.() -> Unit) {
        selector.forEach {
            rules.add(
                Rule(it).apply(init)
            )
        }
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
}

public val EmptyDocument: IDocument = Document()
