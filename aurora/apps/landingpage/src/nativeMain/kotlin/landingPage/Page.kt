package landingPage

import head_lib.CssVM
import head_lib.HeadDto
import head_lib.PageSeoVM
import landingPage.module.LandingPageModule
import modules_lib.navigation.NavigationVM
import page_lib.page.Page

data class LandingPageDto(
    val head: HeadDto,
    val navigation: NavigationVM
)

val landingPage = Page.build(
    name = "landingPage$UniqueId",
    template = LandingPageModule.template,
    externalDocument = LandingPageModule.document
)

val css = CssVM(externalStylingPath = landingPage.getExternalCssPath(), inlineStyling = landingPage.getInlineCss())
val seoData = PageSeoVM("Hello World", "description", "keyword1, keyword2")
val headData = HeadDto(seoData, css)
val navigationDto: NavigationVM = NavigationVM(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(headData, navigationDto)
