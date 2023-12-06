package head.code

import template.StaticTemplateExtension
import template.TemplateExtension
import template.include
import template.tags.Head
import template.tags.Html
import head.Head as HeadVM

internal val SimpleHeadTemplate: TemplateExtension<Html, HeadVM> = { context, data ->
    head {
        include(context=context, template=StaticHead)
        include(context=context, template=DynamicHead, vm=data)
    }
}

internal val DynamicHead: TemplateExtension<Head, HeadVM> = { _, data ->
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
}

internal val StaticHead: StaticTemplateExtension<Head> =  { _, data ->
    meta(charset="UTF-8")
    meta(name="viewport", content="width=device-width, initial-scale=1")
}
