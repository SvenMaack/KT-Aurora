package css.visitors

import css.base.Property
import css.base.Rule
import css.base.RuleVisitor

public class DebugVisitor: RuleVisitor<String> {
    private val _rules = StringBuilder()
    override val result: String
        get() = _rules.toString()

    override fun visitRule(rule: Rule): DebugVisitor {
        _rules.append(
""".${rule.classSelector} {
${renderProperties(rule.properties)}
}
"""
        )
        return this
    }

    private inline fun renderProperties(properties: List<Property>) =
        properties.joinToString(LINE_BREAK){
            INDENTATION + it.toString()
        }

    public companion object {
        public const val LINE_BREAK: String = "\n"
        public const val INDENTATION: String = "\t"
    }
}
