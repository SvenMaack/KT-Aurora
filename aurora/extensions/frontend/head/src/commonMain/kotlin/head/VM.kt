package head

public data class PageSeo(
    val title: String,
    val description: String,
    val keywords: String
)

public data class Css(
    val externalStylingPath: String,
    val inlineStyling: String,
)

public data class Head(
    val pageSeo: PageSeo,
    val css: Css
)
