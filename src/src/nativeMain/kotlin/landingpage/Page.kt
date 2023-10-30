package landingpage

import css_lib.base.Document
import css_lib.properties.margin
import css_lib.properties.px
import page_lib.HeadDto
import page_lib.Page
import page_lib.SimpleHeadTemplate
import template_lib.DynamicTemplate
import template_lib.include
import template_lib.tags.*

data class PageDto(
    val head: HeadDto
)

val pageTemplate: DynamicTemplate<PageDto> = { context, data ->
    html(lang="en") {
        include(context=context, template=SimpleHeadTemplate, dto=data.head)
        include(context=context, template=BodyModule)
    }
}
val document: Document = Document().apply {
    this[".logo"] = {
        margin(50.px)
    }
}

val page = Page(
    pageTemplate,
    document
)
