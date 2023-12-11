package page.base

import css.base.RuleVisitorFactory
import template.base.HtmlVisitorStrategy
import css.visitors.ProductionVisitor as CssProductionVisitor
import css.visitors.DebugVisitor as CssDebugVisitor
import template.visitors.DebugHtmlVisitor
import template.visitors.ProductionHtmlVisitor

public open class Visitors<Result> (
    public val cssVisitor: RuleVisitorFactory<Result>,
    public val htmlVisitor: HtmlVisitorStrategy<Result>
)

public object ProductionVisitors: Visitors<String>(
    { CssProductionVisitor() },
    { ProductionHtmlVisitor() }
)

public object DebugVisitors: Visitors<String>(
    { CssDebugVisitor() },
    { DebugHtmlVisitor() }
)
