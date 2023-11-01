package css_lib.base

interface RuleVisitor<RESULT> {
    val result: RESULT

    fun visitRule(rule: Rule)
}
