package page

import css.ICssRenderer
import css.base.RuleVisitor
import di.Strategy
import template.Context
import template.ITemplateRenderer

//Facade
public class Page<ViewModel>(
    private val name: String,
    private val provider: IPageProvider<ViewModel>,
    private val debug: Boolean = false,
    private val strategy: STRATEGY = STRATEGY
): IPage<ViewModel> {
    private val templateRenderer: ITemplateRenderer = getTemplateRenderer()
    private val cssRenderer: ICssRenderer<String> = strategy.cssRenderer()

    override fun getExternalCss(): String =
        cssRenderer.render(
            getCssVisitor(),
            provider.getExternalCssDocument()
        )

    override fun getInlineCss(): String =
        cssRenderer.render(
            getCssVisitor(),
            provider.getInlineCssDocument()
        )

    override fun getExternalCssPath(): String =
        "$name.css"

    override fun getHtml(pageContext: PageContext, viewModel: ViewModel): String {
        val context = getContext(
            pageContext,
            templateRenderer
        )
        return templateRenderer.render(context, provider.getTemplate(), viewModel)
    }

    private inline fun getContext(pageContext: PageContext, templateRenderer: ITemplateRenderer): Context =
        Context(
            templateRenderer = templateRenderer,
            language = pageContext.language,
            country = pageContext.country,
        )

    private inline fun getCssVisitor(): Strategy<RuleVisitor<String>> =
        if (debug)
            strategy.debugCssVisitor
        else
            strategy.productionCssVisitor

    private inline fun getTemplateRenderer(): ITemplateRenderer =
        if (debug)
            strategy.debugTemplateRenderer()
        else
            strategy.productionTemplateRenderer()
}
