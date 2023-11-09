package template_lib

import template_lib.base.VisitorFactory

data class CSS (
    val inlineStyling: String = "",
    val externalStylingPath: String = "",
)

data class Context(
    val visitorFactory: VisitorFactory<String>,
    val css: CSS,
)
