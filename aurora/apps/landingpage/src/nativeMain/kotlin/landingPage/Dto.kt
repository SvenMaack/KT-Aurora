package landingPage

import modules_lib.navigation.NavigationDto
import head_lib.HeadDto
import head_lib.PageSeoDto

data class LandingPageDto(
    val head: HeadDto,
    val navigation: NavigationDto
)

val seoData: PageSeoDto = PageSeoDto("Hello World", "description", "keyword1, keyword2")
val headData: HeadDto = HeadDto(seoData)
val navigationDto: NavigationDto = NavigationDto(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(headData, navigationDto)