package template_lib

import template_lib.base.HtmlVisitorFactory

public data class CSS (
    val inlineStyling: String = "",
    val externalStylingPath: String = "",
)

public data class Context(
    val htmlVisitorFactory: HtmlVisitorFactory<String>,
    val css: CSS,
)
