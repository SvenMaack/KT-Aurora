package landingPage.domain

import head.Seo

interface ILandingPageProvider {
    fun getLandingPage(): Seo
}