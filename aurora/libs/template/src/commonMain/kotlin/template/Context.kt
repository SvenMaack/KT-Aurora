package template

import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage

public data class Context(
    val templateRenderer: ITemplateRenderer,
    val language: GeneralLanguage,
    val country: CountryCode,
)
