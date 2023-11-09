package page_lib

import css_lib.base.IDocument
import template_lib.base.VisitorFactory

data class PageContext(
    val visitorFactory: VisitorFactory<String>
)

interface IPage<DTO> {
    val name: String
    val cssPath: String

    fun getHtml(context: PageContext, dto: DTO): String

    fun getCss(): String

    operator fun IDocument.unaryPlus(): IPage<DTO>
}
