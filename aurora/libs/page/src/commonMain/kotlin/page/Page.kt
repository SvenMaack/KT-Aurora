package page_lib.page

import css_lib.base.Document
import css_lib.base.IDocument
import page_lib.page.base.*
import page_lib.page.extensions.BrowserSupport
import page_lib.page.extensions.CachedStyling
import template_lib.CSS
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.base.TagContainer
import template_lib.base.VisitorFactory

class PageContext

interface IPage<ViewModel> {
    fun getExternalCss(): String

    fun getExternalCssPath(): String

    fun getHtml(pageContext: PageContext, viewModel: ViewModel): String
}

class Page<ViewModel> private constructor(
    private val name: String,
    private var provider: IPageProvider<ViewModel>,
    private var renderer: IPageRenderer,
    private val visitors: Visitors<String>
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
            getInlineCss(),
            visitors.htmlVisitor
        )
        return renderer.renderHtml(context, provider.getHtmlTag(context, viewModel))
    }

    private inline fun getInlineCss() =
        renderer.renderInlineCss(
            visitors.cssVisitor,
            provider.getInlineCssDocument()
        )

    private inline fun getContext(
        @Suppress("UNUSED_PARAMETER") pageContext: PageContext,
        inlineStyling: String,
        templateVisitorFactory: VisitorFactory<String>
    ): Context =
        Context(
            templateVisitorFactory,
            CSS(
                inlineStyling,
                getExternalCssPath()
            )
        )

    companion object {
        fun <ViewModel> build(
            name: String,
            template: DynamicTemplate<ViewModel>,
            renderer: IPageRenderer = DefaultRenderer,
            visitors: Visitors<String> = ProductionVisitors,
            inlineDocument: IDocument = Document(),
            externalDocument: IDocument = Document(),
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
                visitors
            )
        }
    }
}
