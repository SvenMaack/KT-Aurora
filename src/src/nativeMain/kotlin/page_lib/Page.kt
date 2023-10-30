package page_lib

import css_lib.base.Document
import css_lib.base.Visitor
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer

class Page<DTO>(
    private val template: DynamicTemplate<DTO>,
    private val cssDocument: Document
) {
    fun renderPage(context: Context, dto: DTO): String =
        TemplateRenderer.render(context, template, dto)

    fun getCss(visitor: Visitor<String>): String {
        cssDocument.traverse(visitor)
        return visitor.result
    }
}
