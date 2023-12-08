package css.base

public interface RuleVisitor<RESULT> {
    public val result: RESULT

    public fun visitRule(rule: IRule): RuleVisitor<RESULT>
}

public fun interface RuleVisitorFactory<RESULT> {
    public fun create(): RuleVisitor<RESULT>
}
