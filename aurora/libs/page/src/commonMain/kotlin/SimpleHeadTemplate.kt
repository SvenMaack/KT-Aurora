package page_lib

import template_lib.*
import template_lib.tags.Head

data class PageSeoDto(
    val title: String,
    val description: String,
    val keywords: String
)

data class HeadDto(
    val pageSeo: PageSeoDto
)

val SimpleHeadTemplate: DynamicTemplate<HeadDto> = { context, data ->
    Head().apply {
        include(context=context, template=StaticHead)
        include(context=context, template=DynamicHead, dto=data)
    }
}

val DynamicHead: DynamicTemplate<HeadDto> = { context, data ->
    Head().childs {
        title {
            +data.pageSeo.title
        }
        meta(name="description", content=data.pageSeo.description)
        meta(name="keywords", content=data.pageSeo.keywords)
        if(context.css.externalStylingPath.isNotEmpty()) {
            link(rel="stylesheet", href=context.css.externalStylingPath)
        }
        if(context.css.inlineStyling.isNotEmpty()) {
            style {
                +context.css.inlineStyling
            }
        }
    }
}

val StaticHead: StaticTemplate = { _ ->
    Head().childs {
        meta(charset="UTF-8")
        meta(name="viewport", content="width=device-width, initial-scale=1")
    }
}
