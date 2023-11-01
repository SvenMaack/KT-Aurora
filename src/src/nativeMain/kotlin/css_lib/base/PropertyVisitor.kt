package css_lib.base

abstract class PropertyVisitor<RESULT>: RuleVisitor<RESULT> {
    override fun visitRule(rule: Rule) {
        rule.properties.forEach(::visitProperty)
    }

    abstract fun visitProperty(property: Property)
}
