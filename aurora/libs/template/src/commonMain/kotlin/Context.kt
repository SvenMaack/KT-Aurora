package template_lib

import template_lib.base.VisitorFactory

public data class CSS (
    val inlineStyling: String = "",
    val externalStylingPath: String = "",
)

public data class Context(
    val visitorFactory: VisitorFactory<String>,
    val css: CSS,
)
