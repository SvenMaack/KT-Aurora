package landingPage

import head.Css
import head.Seo
import head.TechnicalData
import landingPage.module.landingPageModule
import modules_lib.navigation.NavigationVM
import page_lib.page.Page
import page_lib.page.base.DebugVisitors

data class LandingPageDto(
    val technicalData: TechnicalData,
    val navigation: NavigationVM
)

val landingPage = Page.build(
    name = "landingPage$UniqueId",
    template = landingPageModule.template,
    externalDocument = landingPageModule.document,
    visitors = DebugVisitors
)

val css = Css(externalStylingPath = landingPage.getExternalCssPath(), inlineStyling = landingPage.getInlineCss())
val seo = Seo("Hello World", "description", "keyword1, keyword2", "https://www.example.com")
val technicalData = TechnicalData(seo, css)
val navigationDto: NavigationVM = NavigationVM(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(technicalData, navigationDto)
