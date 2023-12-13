package landingPage.gateway

import css.base.EmptyDocument
import landingPage.domain.LandingPageProvider
import landingPage.domain.NavigationProvider
import page.IPage
import page.IPageProvider
import page.Page
import page.PageContext
import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage
import kotlinx.coroutines.*
import landingPage.gateway.module.LandingPageDocument
import landingPage.gateway.module.LandingPageTemplate

internal object LandingPage {
    private val landingPage: IPage<LandingPageVM> = Page(
        name = "landingPage_$UniqueId",
        provider = IPageProvider.build(
            inlineCss = EmptyDocument,
            externalCss = LandingPageDocument,
            template = LandingPageTemplate
        ),
        debug = true
    )

    suspend fun getHtml(): String =
        coroutineScope {
            val landingPageData = async { LandingPageProvider().getLandingPage() }
            val navigationData = async { NavigationProvider().getNavigation() }
            landingPage.getHtml(
                PageContext(
                    GeneralLanguage.English,
                    CountryCode.UNITED_STATES
                ),
                LandingPageVM(
                    landingPage,
                    landingPageData.await(),
                    navigationData.await()
                )
            )
        }

    fun getExternalCss(): String =
        landingPage.getExternalCss()

    fun getExternalCssPath(): String =
        landingPage.getExternalCssPath()
}
