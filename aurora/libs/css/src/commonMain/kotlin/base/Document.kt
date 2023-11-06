package css_lib.base

open class Document {
    private var _rules : MutableList<Rule> = mutableListOf()
    internal val rules: List<Rule> = _rules

    operator fun set(vararg selector: String, init: Rule.() -> Unit) {
        selector.forEach {
            _rules.add(
                Rule(it).apply(init)
            )
        }
    }

    open fun traverse(visitor: RuleVisitor<*>) {
        _rules.forEach {
            visitor.visitRule(it)
        }
    }
}
