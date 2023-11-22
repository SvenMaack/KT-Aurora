package page_lib.page.base

import css_lib.base.RuleVisitorFactory
import css_lib.visitors.ProductionVisitor as CssProductionVisitor
import css_lib.visitors.DebugVisitor as CssDebugVisitor
import template_lib.visitors.ProductionVisitor as HtmlProductionVisitor
import template_lib.visitors.DebugVisitor as HtmlDebugVisitor
import template_lib.base.VisitorFactory

open class Visitors<Result> (
    val cssVisitor: RuleVisitorFactory<Result>,
    val htmlVisitor: VisitorFactory<Result>
)

object ProductionVisitors: Visitors<String>(
    { CssProductionVisitor() },
    { HtmlProductionVisitor() }
)

object DebugVisitors: Visitors<String>(
    { CssDebugVisitor() },
    { HtmlDebugVisitor() }
)
