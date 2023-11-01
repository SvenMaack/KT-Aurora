package css_lib.visitors

import css_lib.base.Rule
import css_lib.base.RuleVisitor

class ProductionVisitor: RuleVisitor<String> {
    private val _rules = StringBuilder()
    override val result: String
        get() = _rules.toString()

    override fun visitRule(rule: Rule) {
        _rules.append("${rule.selector}{${rule.properties.joinToString("")}}")
    }
}
