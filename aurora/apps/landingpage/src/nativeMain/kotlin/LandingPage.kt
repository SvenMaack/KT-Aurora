package landingpage

import css_lib.base.Document
import css_lib.base.IDocument
import css_lib.properties.margin
import css_lib.properties.px
import modules_lib.navigation.NavigationDto
import modules_lib.navigation.NavigationModule
import page_lib.*
import page_lib.styling.EmptyStyling
import page_lib.styling.EmptyStylingProvider
import page_lib.styling.RemoveUnusedSelectors
import page_lib.styling.Styling
import template_lib.CSS
import template_lib.Context
import template_lib.DynamicTemplate
import template_lib.base.Element
import template_lib.include
import template_lib.tags.*

data class LandingPageDto(
    val head: HeadDto,
    val navigation: NavigationDto
)

val seoData: PageSeoDto = PageSeoDto("Hello World", "description", "keyword1, keyword2")
val headData: HeadDto = HeadDto(seoData)
val navigationDto: NavigationDto = NavigationDto(listOf("Home", "Trends", "New Arrival", "Sales"))
val pageData: LandingPageDto = LandingPageDto(headData, navigationDto)

val landingPageTemplate: DynamicTemplate<LandingPageDto> = { context, data ->
    html(lang="en") {
        include(context=context, template=SimpleHeadTemplate, dto=data.head)
        include(context=context, template=BodyModule, dto=data.navigation)
    }
}
val defaultLandingPage: Element = landingPageTemplate(
    Context(productionContext.visitorFactory, CSS("","")),
    pageData
)


val landingPageDocument: IDocument = Document().apply {
    this["logo"] = {
        margin(50.px)
    }
}

val stylingProvider = Styling.Builder(
    caching = true,
    riggers = mutableListOf(RemoveUnusedSelectors(defaultLandingPage))
).build()
val inlineStylingProvider = EmptyStylingProvider

val landingPage: IPage<LandingPageDto> = Page(
    name = "landingPage",
    template = landingPageTemplate,
    stylingProvider = stylingProvider,
    inlineStylingProvider = inlineStylingProvider
).apply {
    +landingPageDocument
    +NavigationModule.document
}
