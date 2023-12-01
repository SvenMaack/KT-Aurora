package template

import template.base.HtmlVisitorStrategy

public data class Context(
    val htmlVisitorStrategy: HtmlVisitorStrategy<String>,
    val templateRenderer: ITemplateRenderer
)
