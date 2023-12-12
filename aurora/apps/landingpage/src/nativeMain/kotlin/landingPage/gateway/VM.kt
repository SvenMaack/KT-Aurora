package landingPage.gateway

import head.CssVM
import head.SeoVM
import head.TechnicalDataVM
import landingPage.domain.Navigation
import landingPage.domain.Seo
import navigation.NavigationVM
import page.IPage

internal data class LandingPageVM(
    val technicalData: TechnicalDataVM,
    val navigation: NavigationVM
) {
    constructor(
        page: IPage<LandingPageVM>,
        seo: Seo,
        navigation: Navigation
    ) : this(
        object: TechnicalDataVM {
            override val css = object : CssVM {
                override val externalStylingPath: String = page.getExternalCssPath()
                override val inlineStyling: String = page.getInlineCss()
            }
            override val seo: SeoVM = seo.toSeoVM()
        },
        navigation.toNavigationVM()
    )
}
