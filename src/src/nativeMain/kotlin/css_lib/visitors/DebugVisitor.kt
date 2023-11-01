package css_lib.visitors

import css_lib.base.Rule
import css_lib.base.RuleVisitor

class DebugVisitor: RuleVisitor<String> {
    companion object {
        const val LINE_BREAK = "\n"
        const val INDENTATION = "\t"
    }

    private val _rules = StringBuilder()
    override val result: String
        get() = _rules.toString()

    override fun visitRule(rule: Rule) {
        _rules.append("""${rule.selector} {
${rule.properties.joinToString(LINE_BREAK){
    INDENTATION +it.toString()
}}
}
"""
        )
    }
}
