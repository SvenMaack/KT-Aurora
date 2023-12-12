package page.extensions

import css.ICssRenderer
import css.base.DocumentList
import css.base.IDocument
import css.base.RuleVisitorFactory
import css.base.browser.NOT_SUPPORTED
import css.visitors.BrowserVersionVisitor

public class BrowserSupport(private val inner: ICssRenderer<String>): ICssRenderer<String> {
    private fun renderSupport(support: Map<String, Double>) : String =
        support.entries.joinToString(", ") { (browser, version) ->
            "$browser ${if(version == NOT_SUPPORTED) "not supported" else " >= $version"}"
        }

    override fun render(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String {
        val support = BrowserVersionVisitor().apply {
            DocumentList().apply {
                +document
            }.traverse(this)
        }.result
        val innerResult = inner.render(ruleVisitorFactory, document)
        return if(innerResult.isEmpty()) "" else "/*${renderSupport(support)}*/\n$innerResult"
    }
}
