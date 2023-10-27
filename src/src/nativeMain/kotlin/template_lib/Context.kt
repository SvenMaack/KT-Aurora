package template_lib

import template_lib.base.VisitorFactory

data class Context(
    val visitorFactory: VisitorFactory<String>
)
