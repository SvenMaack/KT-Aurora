package css_lib.base

interface RuleVisitor<RESULT> {
    val result: RESULT

    fun visitRule(rule: Rule): RuleVisitor<RESULT>
}

fun interface RuleVisitorFactory<RESULT> {
    fun create(): RuleVisitor<RESULT>
}
