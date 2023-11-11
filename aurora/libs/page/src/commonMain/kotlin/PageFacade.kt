package page_lib

import css_lib.base.RuleVisitorFactory
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.StaticTemplate
import template_lib.base.VisitorFactory

interface IPageFacade {
    val cssPath: String

    fun getHtml(pageContext: PageContext, template: StaticTemplate): String

    fun <DTO>getHtml(pageContext: PageContext, template: DynamicTemplate<DTO>, dto: DTO): String

    fun getExternalCss(): String
}

internal class PageFacade(
    private val page: IPage,
    private val ruleVisitorFactory: RuleVisitorFactory<String>,
    private val visitorFactory: VisitorFactory<String>
): IPageFacade {
    override val cssPath: String = page.cssPath

    override fun getHtml(pageContext: PageContext, template: StaticTemplate): String {
        val context: Context = getContext(pageContext)
        return page.getHtml(getContext(pageContext), template(context))
    }

    override fun <DTO>getHtml(pageContext: PageContext, template: DynamicTemplate<DTO>, dto: DTO): String {
        val context: Context = getContext(pageContext)
        return page.getHtml(context, template(context, dto))
    }

    override fun getExternalCss(): String =
        page.getExternalCss(ruleVisitorFactory)

    private inline fun getContext(pageContext: PageContext): Context =
        page.getContext(pageContext, page.getInternalCss(ruleVisitorFactory), visitorFactory)
}
