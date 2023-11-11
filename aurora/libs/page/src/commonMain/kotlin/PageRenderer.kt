package page_lib

import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory
import template_lib.CSS
import template_lib.Context
import template_lib.TemplateRenderer
import template_lib.base.TagContainer
import template_lib.base.VisitorFactory

internal class PageRenderer(
    name: String,
    override val externalDocument: IDocument,
    override val internalDocument: IDocument,
): IPage {
    override val cssPath: String = "$name.css"

    override fun getHtml(context: Context, tag: TagContainer): String = TemplateRenderer.render(
        context,
        tag
    )

    override fun getExternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String =
        getRenderedCss(externalDocument, ruleVisitorFactory)

    override fun getInternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String =
        getRenderedCss(internalDocument, ruleVisitorFactory)

    override fun getContext(pageContext: PageContext, inlineStyling: String, visitorFactory: VisitorFactory<String>): Context =
        Context(
            visitorFactory,
            CSS(
                inlineStyling,
                cssPath
            )
        )

    private fun getRenderedCss(document: IDocument, ruleVisitorFactory: RuleVisitorFactory<String>): String {
        val ruleVisitor = ruleVisitorFactory.create()
        document.traverse(ruleVisitor)
        return ruleVisitor.result
    }
}
