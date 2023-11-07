package landingpage

import css_lib.base.Document
import css_lib.properties.margin
import css_lib.properties.px
import modules_lib.navigation.NavigationDto
import modules_lib.navigation.NavigationModule
import page_lib.*
import template_lib.DynamicTemplate
import template_lib.include
import template_lib.tags.*

data class LandingPageDto(
    val head: HeadDto,
    val navigation: NavigationDto
)

val landingPageTemplate: DynamicTemplate<LandingPageDto> = { context, data ->
    html(lang="en") {
        include(context=context, template=SimpleHeadTemplate, dto=data.head)
        include(context=context, template=BodyModule, dto=data.navigation)
    }
}

val landingPageDocument: Document = Document().apply {
    this[".logo"] = {
        margin(50.px)
    }
}

val landingPage: IPage<LandingPageDto> = Page(
    "landingPage",
    landingPageTemplate,
    productionRuleVisitor,
).apply {
    +landingPageDocument
    +NavigationModule.document
}
