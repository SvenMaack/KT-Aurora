package head

public data class Seo(
    val title: String,
    val description: String,
    val keywords: String,
    val canonicalUrl: String,
)

public data class Css(
    val externalStylingPath: String,
    val inlineStyling: String,
)

public data class TechnicalData(
    val seo: Seo,
    val css: Css
)
