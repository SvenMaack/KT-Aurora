package page_lib.page.base

import base.CssRenderer
import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory
import template.Context
import template.base.TagContainer

interface IPageRenderer {
    fun renderHtml(context: Context, tagContainer: TagContainer): String
    fun renderInlineCss(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String
    fun renderExternalCss(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String =
        renderInlineCss(ruleVisitorFactory, document)
}

object DefaultRenderer: IPageRenderer {
    override fun renderHtml(context: Context, tagContainer: TagContainer): String =
        context.templateRenderer.render(context, tagContainer)

    override fun renderInlineCss(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String =
        CssRenderer.render(ruleVisitorFactory, document)
}
