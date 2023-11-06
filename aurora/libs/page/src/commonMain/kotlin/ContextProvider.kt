package page_lib

import template_lib.visitors.DebugVisitor
import template_lib.visitors.ProductionVisitor

val productionContext: PageContext = PageContext { ProductionVisitor() }
val debugContext: PageContext = PageContext { DebugVisitor() }
