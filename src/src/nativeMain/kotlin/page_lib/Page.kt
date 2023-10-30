package page_lib

import css_lib.base.Document
import css_lib.base.Visitor
import kotlinx.datetime.Clock
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer

class Page<DTO>(
    private val template: DynamicTemplate<DTO>,
    private val cssDocument: Document
) {
    private val uniqueName: Lazy<String> = lazy {
        "${this.hashCode()}_${Clock.System.now().toEpochMilliseconds()}"
    }

    fun renderPage(context: Context, dto: DTO): String =
        TemplateRenderer.render(context, template, dto)

    fun getCss(visitor: Visitor<String>): String {
        cssDocument.traverse(visitor)
        return visitor.result
    }

    fun getUniqueName(): String =
        uniqueName.value
}
