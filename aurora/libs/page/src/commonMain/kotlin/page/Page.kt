package page_lib.page

import css.base.Document
import css.base.IDocument
import page_lib.page.base.*
import page_lib.page.extensions.BrowserSupport
import page_lib.page.extensions.CachedStyling
import template.Context
import template.ITemplateRenderer
import template.TemplateRenderer
import template.Template
import template.base.HtmlVisitorStrategy
import template.base.TagContainer

class PageContext

interface IPage<ViewModel> {
    fun getExternalCss(): String

    fun getExternalCssPath(): String

    fun getInlineCss(): String

    fun getHtml(pageContext: PageContext, viewModel: ViewModel): String
}

class Page<ViewModel> private constructor(
    private val name: String,
    private var provider: IPageProvider<ViewModel>,
    private var renderer: IPageRenderer,
    private val visitors: Visitors<String>,
    private val templateRenderer: ITemplateRenderer
): IPage<ViewModel> {
    override fun getExternalCss(): String =
        renderer.renderExternalCss(
            visitors.cssVisitor,
            provider.getExternalCssDocument()
        )

    override fun getExternalCssPath(): String =
        "$name.css"

    override fun getHtml(pageContext: PageContext, viewModel: ViewModel): String {
        val context = getContext(
            pageContext,
            visitors.htmlVisitor,
            templateRenderer
        )
        return renderer.renderHtml(context, provider.getHtmlTag(context, viewModel))
    }

    override fun getInlineCss() =
        renderer.renderInlineCss(
            visitors.cssVisitor,
            provider.getInlineCssDocument()
        )

    private inline fun getContext(
        @Suppress("UNUSED_PARAMETER") pageContext: PageContext,
        templateVisitorFactory: HtmlVisitorStrategy<String>,
        templateRenderer: ITemplateRenderer
    ): Context =
        Context(
            templateVisitorFactory,
            templateRenderer
        )

    companion object {
        fun <ViewModel> build(
            name: String,
            template: Template<ViewModel>,
            renderer: IPageRenderer = DefaultRenderer,
            visitors: Visitors<String> = ProductionVisitors,
            inlineDocument: IDocument = Document(),
            externalDocument: IDocument = Document(),
            templateRenderer: ITemplateRenderer = TemplateRenderer()
        ) : IPage<ViewModel> {
            val provider = object : IPageProvider<ViewModel> {
                override fun getHtmlTag(context: Context, viewModel: ViewModel): TagContainer =
                    template(context, viewModel)

                override fun getInlineCssDocument(): IDocument =
                    inlineDocument

                override fun getExternalCssDocument(): IDocument =
                    externalDocument
            }

            return Page(
                name,
                BrowserSupport(provider),
                CachedStyling(renderer),
                visitors,
                templateRenderer
            )
        }
    }
}
