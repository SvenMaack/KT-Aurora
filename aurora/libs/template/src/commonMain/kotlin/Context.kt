package template_lib

import template_lib.base.HtmlVisitorStrategy

public data class Context(
    val htmlVisitorStrategy: HtmlVisitorStrategy<String>,
    val templateRenderer: ITemplateRenderer
)
