package css_lib.visitors

import css_lib.base.Rule
import css_lib.base.RuleVisitor
import kotlin.math.max

class BrowserVersionVisitor: RuleVisitor<Map<String, Double>> {
    override val result: MutableMap<String, Double> = mutableMapOf()

    override fun visitRule(rule: Rule) {
        rule.properties.forEach {
            it.supportedBrowsers.forEach { support ->
                result[support.browserName] = max(
                    support.minimalSupportedVersion(),
                    result.getOrElse(support.browserName) {0.0}
                )
            }
        }
    }
}
