package css.base

public abstract class PropertyVisitor<RESULT>: RuleVisitor<RESULT> {
    override fun visitRule(rule: IRule): PropertyVisitor<RESULT> {
        rule.properties.forEach(::visitProperty)
        return this
    }

    public abstract fun visitProperty(property: Property): PropertyVisitor<RESULT>
}
