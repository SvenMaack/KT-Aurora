package landingPage.domain

import head.Seo

internal class LandingPageProvider: ILandingPageProvider {
    override fun getLandingPage(): Seo =
        Seo(
            title = "Aurora",
            description = "A PoC for the power of kotlin",
            keywords = "landingpage, kotlin, multiplatform",
            canonicalUrl = "https://www.example.com"
        )
}
