package css.base

public interface IDocument {
    public fun traverse(visitor: RuleVisitor<*>)
    public fun gatherDocuments(set: MutableSet<IDocument>)
}

@Suppress("ClassOrdering")
public open class Document: IDocument {
    internal val rules : MutableList<IRule> = mutableListOf()

    override fun traverse(visitor: RuleVisitor<*>) {
        rules.forEach {
            visitor.visitRule(it)
        }
    }

    override fun gatherDocuments(set: MutableSet<IDocument>) {
        set.add(this)
    }

    //Class
    public object Clazz
    public val clazz: Clazz = Clazz
    public operator fun Clazz.set(vararg selectors: String, init: Rule.() -> Unit) {
        addRule(*selectors, fac = ::Class).apply(init)
    }

    //Tag
    public object Tag
    public val tag: Tag = Tag
    public operator fun Tag.set(vararg selectors: String, init: Rule.() -> Unit) {
        addRule(*selectors, fac = ::Tag).apply(init)
    }

    //Id
    public object Id
    public val id: Id = Id
    public operator fun Id.set(vararg selectors: String, init: Rule.() -> Unit) {
        addRule(*selectors, fac = ::Id).apply(init)
    }

    //everything else
    public operator fun set(vararg selectors: Selector, init: Rule.() -> Unit) {
        if(selectors.size == 1)
            rules.add(Rule(selectors[0]).apply(init))
        else if(selectors.size > 1)
            rules.add(
                Rule(CombinedSelector(*selectors)).apply(init)
            )
    }

    @Suppress("SpreadOperator")
    @PublishedApi internal fun addRule(vararg selectors: String, fac: (String) -> Selector): Rule {
        val rule: Rule = if(selectors.size == 1)
            Rule(
                fac(selectors[0])
            )
        else Rule(
                CombinedSelector(*selectors.map { fac(it) }.toTypedArray())
            )
        return rule.apply { +this }
    }

    internal operator fun Rule.unaryPlus() {
        rules.add(this)
    }
}

public val EmptyDocument: IDocument = Document()
