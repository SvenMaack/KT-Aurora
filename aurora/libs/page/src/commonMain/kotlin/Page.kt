package page_lib

import css_lib.base.DocumentList
import css_lib.base.IDocument
import css_lib.visitors.BrowserVersionVisitor
import page_lib.styling.EmptyStylingProvider
import page_lib.styling.StylingProvider
import template_lib.CSS
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer
import template_lib.base.TagContainer

class Page<DTO>(
    override val name: String,
    private val template: DynamicTemplate<DTO>,
    private val stylingProvider: StylingProvider,
    private val inlineStylingProvider: StylingProvider = EmptyStylingProvider
): IPage<DTO> {
    internal val cssDocument: DocumentList = DocumentList()

    override val cssPath: String = "$name.css"

    override fun getHtml(context: PageContext, dto: DTO): String =
        TemplateRenderer.render(
            createContext(context),
            renderTemplateWithBrowserSupport(context, dto)
        )

    override fun getCss(): String =
        stylingProvider(cssDocument).getCss()

    override operator fun IDocument.unaryPlus(): IPage<DTO> {
        cssDocument.add(this)
        return this@Page
    }

    private fun getMinimumBrowserVersions(): Map<String, Double> =
        BrowserVersionVisitor().apply {
            cssDocument.traverse(this)
        }.result

    private fun renderTemplateWithBrowserSupport(context: PageContext, dto: DTO): TagContainer =
        template(createContext(context), dto).apply {
            val newAttributes: MutableMap<String, List<String>> = mutableMapOf()
            newAttributes.putAll(attributes)
            getMinimumBrowserVersions().forEach {
                newAttributes[it.key] = listOf(it.value.toString())
            }
            attributes = newAttributes
        }

    private fun createContext(pageContext: PageContext): Context =
        Context(
            pageContext.visitorFactory,
            CSS(
                inlineStylingProvider(cssDocument).getCss(),
                cssPath
            )
        )
}
