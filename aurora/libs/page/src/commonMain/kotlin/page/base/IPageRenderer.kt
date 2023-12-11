package page.base

import css.CssRenderer
import css.base.IDocument
import css.base.RuleVisitorFactory
import template.Context
import template.base.TagContainer

public interface IPageRenderer {
    public fun renderHtml(context: Context, tagContainer: TagContainer): String
    public fun renderInlineCss(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String
    public fun renderExternalCss(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String =
        renderInlineCss(ruleVisitorFactory, document)
}

public object DefaultRenderer: IPageRenderer {
    override fun renderHtml(context: Context, tagContainer: TagContainer): String =
        context.templateRenderer.render(context, tagContainer)

    override fun renderInlineCss(ruleVisitorFactory: RuleVisitorFactory<String>, document: IDocument): String =
        CssRenderer.render(ruleVisitorFactory, document)
}
