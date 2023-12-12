package landingPage

import css.base.EmptyDocument
import head.Css
import head.Seo
import head.TechnicalData
import landingPage.module.landingPageModule
import navigation.NavigationEntry
import navigation.NavigationVM
import page.IPageProvider
import page.Page

data class LandingPageDto(
    val technicalData: TechnicalData,
    val navigation: NavigationVM
)

val landingPage = Page(
    name = "landingPage$UniqueId",
    provider = IPageProvider.build(
        inlineCss = EmptyDocument,
        externalCss = landingPageModule.document,
        template = landingPageModule.template
    ),
    debug = true
)

val css = Css(externalStylingPath = landingPage.getExternalCssPath(), inlineStyling = landingPage.getInlineCss())
val seo = Seo(
    "Hello World",
    "description",
    "keyword1, keyword2",
    "https://www.example.com"
)
val technicalData = TechnicalData(seo, css)
val NavigationEntries = listOf(
    NavigationEntry("Home"),
    NavigationEntry("Trends", active = true),
    NavigationEntry("New Arrival"),
    NavigationEntry("Sales")
)
val navigationDto: NavigationVM = NavigationVM(NavigationEntries)
val pageData: LandingPageDto = LandingPageDto(technicalData, navigationDto)
