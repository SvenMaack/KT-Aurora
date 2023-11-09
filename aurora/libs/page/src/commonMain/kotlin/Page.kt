package page_lib

import base.CssRenderer
import css_lib.base.DocumentList
import css_lib.base.IDocument
import css_lib.visitors.BrowserVersionVisitor
import css_lib.base.RuleVisitorFactory
import template_lib.CSS
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer

class Page<DTO>(
    override val name: String,
    private val template: DynamicTemplate<DTO>,
    private val ruleVisitorFactory: RuleVisitorFactory<String>
): IPage<DTO> {
    internal val cssDocument: DocumentList = DocumentList()

    override val cssPath: String = "$name.css"

    override fun getHtml(context: PageContext, dto: DTO): String =
        TemplateRenderer.render(
            createContext(context),
            template,
            dto
        )

    override fun getCss(): String {
        val support = getMinimumBrowserVersions()
        val css = CssRenderer.render(ruleVisitorFactory, cssDocument)
        return "#$support\n$css"
    }

    override operator fun IDocument.unaryPlus(): IPage<DTO> {
        cssDocument.add(this)
        return this@Page
    }

    private fun getMinimumBrowserVersions(): Map<String, Double> {
        val browserVersionVisitor = BrowserVersionVisitor()
        cssDocument.traverse(browserVersionVisitor)
        return browserVersionVisitor.result
    }

    private fun createContext(pageContext: PageContext): Context =
        Context(
            pageContext.visitorFactory,
            CSS(
               "",
                cssPath
            )
        )
}
