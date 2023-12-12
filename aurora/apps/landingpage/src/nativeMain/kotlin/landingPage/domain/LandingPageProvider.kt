package landingPage.domain

private data class DummySeo (
    override val title: String,
    override val description: String,
    override val keywords: String,
    override val canonicalUrl: String
): Seo

internal class LandingPageProvider: ILandingPageProvider {
    override suspend fun getLandingPage(): Seo =
        DummySeo(
            title = "Aurora",
            description = "A PoC for the power of kotlin",
            keywords = "landingPage, kotlin, multiplatform",
            canonicalUrl = "https://www.example.com"
        )
}
