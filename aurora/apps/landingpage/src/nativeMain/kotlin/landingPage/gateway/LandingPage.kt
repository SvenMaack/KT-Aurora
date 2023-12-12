package landingPage.gateway

import css.base.EmptyDocument
import landingPage.domain.LandingPageProvider
import landingPage.domain.NavigationProvider
import landingPage.gateway.module.LandingPageModule
import page.IPage
import page.IPageProvider
import page.Page
import page.PageContext
import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage

internal object LandingPage {
    private val landingPage: IPage<LandingPageVM> = Page(
        name = "landingPage_$UniqueId",
        provider = IPageProvider.build(
            inlineCss = EmptyDocument,
            externalCss = LandingPageModule.document,
            template = LandingPageModule.template
        ),
        debug = true
    )

    suspend fun getHtml(): String =
        landingPage.getHtml(
            PageContext(
                GeneralLanguage.English,
                CountryCode.UNITED_STATES
            ),
            LandingPageVM(
                landingPage,
                LandingPageProvider().getLandingPage(),
                NavigationProvider().getNavigation()
            )
        )

    fun getExternalCss(): String =
        landingPage.getExternalCss()

    fun getExternalCssPath(): String =
        landingPage.getExternalCssPath()
}
