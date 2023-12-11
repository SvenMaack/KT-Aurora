package page

import css.base.Document
import css.base.IDocument
import page.base.*
import page.extensions.BrowserSupport
import page.extensions.CachedStyling
import template.Context
import template.ITemplateRenderer
import template.TemplateRenderer
import template.Template
import template.base.TagContainer
import template.tags.enums.SpecificLanguage

public data class PageContext(
    public val language: SpecificLanguage
)

public interface IPage<ViewModel> {
    public fun getExternalCss(): String

    public fun getExternalCssPath(): String

    public fun getInlineCss(): String

    public fun getHtml(pageContext: PageContext, viewModel: ViewModel): String
}

public class Page<ViewModel> private constructor(
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
            templateRenderer
        )
        return renderer.renderHtml(context, provider.getHtmlTag(context, viewModel))
    }

    override fun getInlineCss(): String =
        renderer.renderInlineCss(
            visitors.cssVisitor,
            provider.getInlineCssDocument()
        )

    private inline fun getContext(
        pageContext: PageContext,
        templateRenderer: ITemplateRenderer
    ): Context =
        Context(
            templateRenderer = templateRenderer,
            language = pageContext.language
        )

    public companion object {
        public fun <ViewModel> build(
            name: String,
            template: Template<ViewModel>,
            renderer: IPageRenderer = DefaultRenderer,
            visitors: Visitors<String> = ProductionVisitors,
            inlineDocument: IDocument = Document(),
            externalDocument: IDocument = Document(),
            templateRenderer: ITemplateRenderer = TemplateRenderer(visitors.htmlVisitor)
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
