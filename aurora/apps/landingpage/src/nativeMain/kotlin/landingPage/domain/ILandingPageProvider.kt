package landingPage.domain

public interface Seo {
    public val title: String
    public val description: String
    public val keywords: String
    public val canonicalUrl: String
}

internal interface ILandingPageProvider {
    suspend fun getLandingPage(id: String): Seo
}
