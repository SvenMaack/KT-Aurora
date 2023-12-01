package head_lib

import template_lib.*
import template_lib.tags.Head

data class PageSeoVM(
    val title: String,
    val description: String,
    val keywords: String
)

data class CssVM(
    val externalStylingPath: String,
    val inlineStyling: String,
)

data class HeadDto(
    val pageSeo: PageSeoVM,
    val css: CssVM
)

val SimpleHeadTemplate: Template<HeadDto> = { context, data ->
    Head().apply {
        include(context=context, template=StaticHead)
        include(context=context, template=DynamicHead, vm=data)
    }
}

val DynamicHead: Template<HeadDto> = { _, data ->
    Head().apply {
        title {
            +data.pageSeo.title
        }
        meta(name="description", content=data.pageSeo.description)
        meta(name="keywords", content=data.pageSeo.keywords)
        if(data.css.externalStylingPath.isNotEmpty()) {
            link(rel="stylesheet", href=data.css.externalStylingPath)
        }
        if(data.css.inlineStyling.isNotEmpty()) {
            style {
                +data.css.inlineStyling
            }
        }
    }.childs()
}

val StaticHead: StaticTemplate = { _, _ ->
    Head().apply {
        meta(charset="UTF-8")
        meta(name="viewport", content="width=device-width, initial-scale=1")
    }.childs()
}
