package page_lib

import css_lib.base.Document
import css_lib.base.Visitor
import kotlinx.datetime.Clock
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer
import template_lib.base.VisitorFactory

data class PageContext(
    val visitorFactory: VisitorFactory<String>
)

class Page<DTO>(
    private val template: DynamicTemplate<DTO>,
    private val cssDocument: Document
) {
    private val uniqueName: Lazy<String> = lazy {
        "${this.hashCode()}_${Clock.System.now().toEpochMilliseconds()}"
    }

    private fun createContext(pageContext: PageContext): Context =
        Context(
            pageContext.visitorFactory,
            getUniqueId()
        )

    fun renderPage(context: PageContext, dto: DTO): String =
        TemplateRenderer.render(createContext(context), template, dto)

    fun getCss(visitor: Visitor<String>): String {
        cssDocument.traverse(visitor)
        return visitor.result
    }

    fun getUniqueId(): String =
        uniqueName.value
}
