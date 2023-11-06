package page_lib

import css_lib.base.Document
import css_lib.base.DocumentComposite
import css_lib.base.RuleVisitor
import css_lib.visitors.BrowserVersionVisitor
import kotlinx.datetime.Clock
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.TemplateRenderer
import template_lib.base.VisitorFactory

data class PageContext(
    val visitorFactory: VisitorFactory<String>
)

class Page<DTO>(
    private val template: DynamicTemplate<DTO>,
    cssDocument: Document
) {
    private val name: Lazy<String> = lazy {
        "test"//${this.hashCode()}_${Clock.System.now().toEpochMilliseconds()}"
    }
    internal val _cssDocument: DocumentComposite = DocumentComposite()

    init {
        addDocument(cssDocument)
    }

    fun renderPage(context: PageContext, dto: DTO): String =
        TemplateRenderer.render(createContext(context), template, dto)

    fun getCss(visitor: RuleVisitor<String>): String {
        _cssDocument.traverse(visitor)
        return visitor.result
    }

    fun addDocument(document: Document): Page<DTO> {
        _cssDocument.addDocument(document)
        return this
    }

    fun getId(): String =
        name.value

    fun getMinimumBrowserVersions(): Map<String, Double> {
        val browserVersionVisitor = BrowserVersionVisitor()
        _cssDocument.traverse(browserVersionVisitor)
        return browserVersionVisitor.result
    }

    private fun createContext(pageContext: PageContext): Context =
        Context(
            pageContext.visitorFactory,
            getId()
        )
}
