package head

import template.StaticTemplateExtension
import template.TemplateExtension
import template.include
import template.tags.Head as HeadTag
import template.tags.Html

internal val SimpleHeadTemplate: TemplateExtension<Html, TechnicalData> = { context, data ->
    head {
        include(context=context, template=StaticHead)
        include(context=context, template=DynamicHead, vm=data)
    }
}

internal val DynamicHead: TemplateExtension<HeadTag, TechnicalData> = { _, data ->
    title {
        +data.seo.title
    }
    meta(name="description", content=data.seo.description)
    meta(name="keywords", content=data.seo.keywords)
    if(data.css.externalStylingPath.isNotEmpty())
        link(rel="stylesheet", href=data.css.externalStylingPath)
    if(data.css.inlineStyling.isNotEmpty())
        style {
            +data.css.inlineStyling
        }
}

internal val StaticHead: StaticTemplateExtension<HeadTag> =  { _, _ ->
    meta(charset="UTF-8")
    meta(name="viewport", content="width=device-width, initial-scale=1")
}
