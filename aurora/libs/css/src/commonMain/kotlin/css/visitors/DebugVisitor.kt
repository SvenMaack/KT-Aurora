package css.visitors

import css.base.IProperty
import css.base.IRule
import css.base.RuleVisitor
import css.base.browser.SupportData

public class DebugVisitor: RuleVisitor<String> {
    private val _rules = StringBuilder()
    override val result: String
        get() = _rules.toString()

    override fun visitRule(rule: IRule): DebugVisitor {
        _rules.append("""
            |${rule.selector} {
            |${renderProperties(rule.properties)}
            |}
        """.trimMargin()+"\n")
        return this
    }

    private inline fun renderProperties(properties: List<IProperty>) =
        properties.joinToString(LINE_BREAK){
            INDENTATION + "/* ${renderBrowserVersion(it.supportedBrowsers)} */" + LINE_BREAK + INDENTATION + it.toString()
        }

    private inline fun renderBrowserVersion(supportData: SupportData): String =
        "chrome: ${supportData.chrome}, firefox: ${supportData.firefox}, safari: ${supportData.safari}, edge: ${supportData.edge}, opera: ${supportData.opera}"

    public companion object {
        public const val LINE_BREAK: String = "\n"
        public const val INDENTATION: String = "\t"
    }
}
