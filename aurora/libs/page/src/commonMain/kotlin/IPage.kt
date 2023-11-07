package page_lib

import css_lib.base.Document
import template_lib.base.VisitorFactory

data class PageContext(
    val visitorFactory: VisitorFactory<String>
)

interface IPage<DTO> {
    val name: String

    fun getHtml(context: PageContext, dto: DTO): String

    fun getCss(): String

    operator fun Document.unaryPlus(): IPage<DTO>
}
