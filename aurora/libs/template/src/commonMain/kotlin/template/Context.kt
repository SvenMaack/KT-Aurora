package template

import template.tags.enums.SpecificLanguage

public data class Context(
    val templateRenderer: ITemplateRenderer,
    val language: SpecificLanguage
)
