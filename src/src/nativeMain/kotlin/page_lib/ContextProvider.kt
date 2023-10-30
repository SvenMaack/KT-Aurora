package page_lib

import template_lib.Context
import template_lib.visitors.ProductionVisitor

val productionContext: Context = Context { ProductionVisitor() }
