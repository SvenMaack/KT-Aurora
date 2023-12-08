package css.visitors

import css.base.IRule
import css.base.Property
import css.base.RuleVisitor

public class ProductionVisitor: RuleVisitor<String> {
    private val _rules = StringBuilder()
    override val result: String
        get() = _rules.toString()

    override fun visitRule(rule: IRule): ProductionVisitor {
        _rules.append("${rule.selector}{${renderProperties(rule.properties)}}")
        return this
    }

    private inline fun renderProperties(properties: List<Property>) =
        properties.joinToString("")
}
