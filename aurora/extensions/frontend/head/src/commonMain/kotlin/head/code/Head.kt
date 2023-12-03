package head.code

import template.Template
import template.StaticTemplate
import template.childs
import template.include
import template.tags.Head
import head.Head as HeadVM

internal val SimpleHeadTemplate: Template<HeadVM> = { context, data ->
    Head().apply {
        include(context=context, template=StaticHead)
        include(context=context, template=DynamicHead, vm=data)
    }
}

internal val DynamicHead: Template<HeadVM> = { _, data ->
    Head().apply {
        title {
            +data.pageSeo.title
        }
        meta(name="description", content=data.pageSeo.description)
        meta(name="keywords", content=data.pageSeo.keywords)
        if(data.css.externalStylingPath.isNotEmpty())
            link(rel="stylesheet", href=data.css.externalStylingPath)
        if(data.css.inlineStyling.isNotEmpty())
            style {
                +data.css.inlineStyling
            }
    }.childs()
}

internal val StaticHead: StaticTemplate = { _, _ ->
    Head().apply {
        meta(charset="UTF-8")
        meta(name="viewport", content="width=device-width, initial-scale=1")
    }.childs()
}
