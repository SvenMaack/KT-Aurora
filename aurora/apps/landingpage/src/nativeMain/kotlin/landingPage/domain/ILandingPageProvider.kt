package landingPage.domain

import head.Seo

internal interface ILandingPageProvider {
    fun getLandingPage(): Seo
}
