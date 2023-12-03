package landingPage

import head.Css
import head.Head
import head.PageSeo
import landingPage.module.LandingPageModule
import modules_lib.navigation.NavigationVM
import page_lib.page.Page
import page_lib.page.base.DebugVisitors

data class LandingPageDto(
    val head: Head,
    val navigation: NavigationVM
)

val landingPage = Page.build(
    name = "landingPage$UniqueId",
    template = LandingPageModule.template,
    externalDocument = LandingPageModule.document,
    visitors = DebugVisitors
)

val css = Css(externalStylingPath = landingPage.getExternalCssPath(), inlineStyling = landingPage.getInlineCss())
val seoData = PageSeo("Hello World", "description", "keyword1, keyword2")
val headData = Head(seoData, css)
val navigationDto: NavigationVM = NavigationVM(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(headData, navigationDto)
