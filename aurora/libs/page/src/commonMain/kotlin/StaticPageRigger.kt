package page_lib

import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory
import template_lib.base.VisitorFactory

data class StaticPageRiggerData (
    val externalDocument: IDocument,
    val internalDocument: IDocument,
    val templateVisitorFactory: VisitorFactory<String>,
    val ruleVisitor: RuleVisitorFactory<String>,
)

fun interface StaticPageRigger {
    fun change(data: StaticPageRiggerData): StaticPageRiggerData
}
