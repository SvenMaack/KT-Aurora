package page_lib

import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory
import template_lib.Context
import template_lib.base.TagContainer
import template_lib.base.VisitorFactory

class PageContext

interface IPage {
    val cssPath: String
    val externalDocument: IDocument
    val internalDocument: IDocument

    fun getHtml(context: Context, tag: TagContainer): String

    fun getExternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String

    fun getInternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String

    fun getContext(pageContext: PageContext, inlineStyling: String, visitorFactory: VisitorFactory<String>): Context
}
