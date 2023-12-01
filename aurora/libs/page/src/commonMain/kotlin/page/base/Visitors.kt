package page_lib.page.base

import css_lib.base.RuleVisitorFactory
import template_lib.base.HtmlVisitorStrategy
import css_lib.visitors.ProductionVisitor as CssProductionVisitor
import css_lib.visitors.DebugVisitor as CssDebugVisitor
import template_lib.visitors.DebugHtmlVisitor
import template_lib.visitors.ProductionHtmlVisitor

open class Visitors<Result> (
    val cssVisitor: RuleVisitorFactory<Result>,
    val htmlVisitor: HtmlVisitorStrategy<Result>
)

object ProductionVisitors: Visitors<String>(
    { CssProductionVisitor() },
    { ProductionHtmlVisitor() }
)

object DebugVisitors: Visitors<String>(
    { CssDebugVisitor() },
    { DebugHtmlVisitor() }
)
