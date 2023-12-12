package page.extensions

import css.ICssRenderer
import css.base.IDocument
import css.base.RuleVisitorFactory
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal object CssCache {
    private val cache: MutableMap<String, String> = mutableMapOf()

    operator fun get(document: IDocument, init: ()->String): String =
        cache.getOrElse(getCacheKey(document)) {
            val timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
            val result = "/*" + timestamp.toString() + "*/\n" + init()
            result.apply {
                cache[getCacheKey(document)] = this
            }
        }

    internal fun clear() {
        cache.clear()
    }

    private inline fun getCacheKey(document: IDocument): String =
        document.toString()
}

public class CachedStyling(private val inner: ICssRenderer<String>): ICssRenderer<String> {
    override fun render(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String =
        CssCache[document, {
            inner.render(ruleVisitorFactory, document)
        }]
}
