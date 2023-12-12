package landingPage.gateway

import css.base.EmptyDocument
import head.Css
import head.TechnicalData
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

    fun renderLandingPage(): String =
        landingPage.getHtml(
            PageContext(
                GeneralLanguage.English,
                CountryCode.UNITED_STATES
            ),
            LandingPageVM(
                TechnicalData(
                    LandingPageProvider().getLandingPage(),
                    Css(
                        externalStylingPath = landingPage.getExternalCssPath(),
                        inlineStyling = landingPage.getInlineCss()
                    )
                ),
                NavigationProvider().getNavigation()
            )
        )

    fun getExternalCss(): String =
        landingPage.getExternalCss()

    fun getExternalCssPath(): String =
        landingPage.getExternalCssPath()
}
