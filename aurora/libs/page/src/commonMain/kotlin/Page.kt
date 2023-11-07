package page_lib

import css_lib.base.Document
import css_lib.base.DocumentComposite
import css_lib.visitors.BrowserVersionVisitor
import css_lib.base.RuleVisitorFactory
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer

class Page<DTO>(
    override val name: String,
    private val template: DynamicTemplate<DTO>,
    private val ruleVisitorFactory: RuleVisitorFactory<String>
): IPage<DTO> {
    private val cssDocument: DocumentComposite = DocumentComposite()

    override fun getHtml(context: PageContext, dto: DTO): String =
        TemplateRenderer.render(
            createContext(context),
            template,
            dto
        )

    override fun getCss(): String {
        val support = getMinimumBrowserVersions()
        val ruleVisitor = ruleVisitorFactory.create().apply {
            cssDocument.traverse(this)
        }
        return "#$support\n${ruleVisitor.result}"
    }

    override operator fun Document.unaryPlus(): IPage<DTO> {
        cssDocument.addDocument(this)
        return this@Page
    }

    fun getMinimumBrowserVersions(): Map<String, Double> {
        val browserVersionVisitor = BrowserVersionVisitor()
        cssDocument.traverse(browserVersionVisitor)
        return browserVersionVisitor.result
    }

    private fun createContext(pageContext: PageContext): Context =
        Context(
            pageContext.visitorFactory,
            name
        )
}
