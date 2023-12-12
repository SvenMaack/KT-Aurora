package landingPage.domain

import head.Seo

class LandingPageProvider: ILandingPageProvider {
    override fun getLandingPage(): Seo =
        Seo(
            title = "Hello World",
            description = "description",
            keywords = "keyword1, keyword2",
            canonicalUrl = "https://www.example.com"
        )
}
