package css.base

public interface RuleVisitor<RESULT> {
    public val result: RESULT

    public fun visitRule(rule: Rule): RuleVisitor<RESULT>
}

public fun interface RuleVisitorFactory<RESULT> {
    public fun create(): RuleVisitor<RESULT>
}
