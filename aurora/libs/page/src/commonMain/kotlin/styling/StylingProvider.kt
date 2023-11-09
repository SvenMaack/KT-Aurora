package page_lib.styling

import base.CssRenderer
import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory
import css_lib.visitors.ProductionVisitor

typealias StylingProvider = (IDocument) -> Styling
val EmptyStylingProvider: StylingProvider = { _ -> EmptyStyling }

interface Styling {
    fun getCss(): String

    data class Builder(
        private val visitor: RuleVisitorFactory<String> = RuleVisitorFactory{ ProductionVisitor() },
        private val caching: Boolean = false,
    ) {
        fun build(): StylingProvider =
            if(caching)
                { document -> CachedStyling(visitor, document) }
            else
                { document -> DefaultStyling(visitor, document) }
    }
}

open class DefaultStyling(private val visitor: RuleVisitorFactory<String>, private val document: IDocument): Styling {
    override fun getCss(): String =
        CssRenderer.render(visitor, document)
}

class CachedStyling(private val visitor: RuleVisitorFactory<String>, private val document: IDocument): Styling {
    private val css: Lazy<String> = lazy {
        DefaultStyling(visitor, document).getCss()
    }

    override fun getCss(): String =
        css.value
}

object EmptyStyling: Styling {
    override fun getCss(): String = ""
}
