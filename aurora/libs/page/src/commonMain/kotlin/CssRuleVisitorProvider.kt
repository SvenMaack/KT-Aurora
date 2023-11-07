package page_lib

import css_lib.base.RuleVisitorFactory
import css_lib.visitors.DebugVisitor
import css_lib.visitors.ProductionVisitor

val productionRuleVisitor: RuleVisitorFactory<String> = RuleVisitorFactory { ProductionVisitor() }
val debugRuleVisitor: RuleVisitorFactory<String> = RuleVisitorFactory { DebugVisitor() }
