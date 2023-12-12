package page

import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage

public data class PageContext(
    public val language: GeneralLanguage,
    public val country: CountryCode,
)

public interface IPage<ViewModel> {
    public fun getExternalCss(): String

    public fun getExternalCssPath(): String

    public fun getInlineCss(): String

    public fun getHtml(pageContext: PageContext, viewModel: ViewModel): String
}
