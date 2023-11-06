package css_lib.base

abstract class PropertyVisitor<RESULT>: RuleVisitor<RESULT> {
    override fun visitRule(rule: Rule): PropertyVisitor<RESULT> {
        rule.properties.forEach(::visitProperty)
        return this
    }

    abstract fun visitProperty(property: Property): PropertyVisitor<RESULT>
}
