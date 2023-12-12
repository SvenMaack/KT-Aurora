package page

import css.CssRenderer
import css.ICssRenderer
import css.base.RuleVisitor
import css.visitors.DebugVisitor
import css.visitors.ProductionVisitor
import di.Strategy
import di.get
import di.by
import page.extensions.CachedStyling
import template.ITemplateRenderer
import template.TemplateRenderer
import template.visitors.debugHtmlVisitorStrategy
import template.visitors.productionHtmlVisitorStrategy

private class CssRendererToString: CssRenderer<String>()

public object STRATEGY {
    public val cssRenderer: Strategy<ICssRenderer<String>> = ::CssRendererToString by ::CachedStyling
    public val debugCssVisitor: Strategy<RuleVisitor<String>> = ::DebugVisitor
    public val productionCssVisitor: Strategy<RuleVisitor<String>> = ::ProductionVisitor
    public val debugTemplateRenderer: Strategy<ITemplateRenderer> = ::TemplateRenderer[::debugHtmlVisitorStrategy]
    public val productionTemplateRenderer: Strategy<ITemplateRenderer> = ::TemplateRenderer[::productionHtmlVisitorStrategy]
}
