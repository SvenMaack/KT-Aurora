package page_lib

import css_lib.base.EmptyDocument
import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory
import css_lib.visitors.ProductionVisitor as DocumentProductionVisitor
import page_lib.runtimeDecorators.BrowserSupportPageDecorator
import page_lib.runtimeDecorators.StylingCachePageDecorator
import template_lib.base.VisitorFactory
import template_lib.visitors.ProductionVisitor as TemplateProductionVisitor

typealias PageDecoratorCreator = (IPage) -> IPage

//TODO: test
data class PageBuilder(
    val name: String,
    val externalDocument: IDocument,
    val internalDocument: IDocument = EmptyDocument,
    val runtimeModifier: PageDecoratorCreator = Identity,
    val staticRiggers: List<StaticPageRigger> = listOf(),
    val roleVisitor: RuleVisitorFactory<String> = RuleVisitorFactory { DocumentProductionVisitor() },
    val templateVisitorFactory: VisitorFactory<String> = VisitorFactory { TemplateProductionVisitor() },
    val pageRenderer: (String, IDocument, IDocument) -> IPage = ::PageRenderer
) {
    fun build(): IPageFacade {
        val data = staticRiggers.foldRight(StaticPageRiggerData(externalDocument, internalDocument, templateVisitorFactory, roleVisitor))
            { current, acc ->
                current.change(acc)
            }

        return PageFacade(
            runtimeModifier(
                pageRenderer(name, data.externalDocument, data.internalDocument)
            ),
            data.ruleVisitor,
            data.templateVisitorFactory
        )
    }
}

val StylingCache: PageDecoratorCreator = { page -> StylingCachePageDecorator(page, { DocumentProductionVisitor() }) }
val BrowserSupport: PageDecoratorCreator = { page -> BrowserSupportPageDecorator(page) }
private val Identity: PageDecoratorCreator = { page -> page }

operator fun PageDecoratorCreator.plus(other: PageDecoratorCreator): PageDecoratorCreator {
    return { page -> this(other(page)) }
}
