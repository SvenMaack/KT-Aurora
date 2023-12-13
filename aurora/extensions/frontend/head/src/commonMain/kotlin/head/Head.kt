package head

import template.Context
import template.StaticTemplateExtension
import template.cache
import template.tags.Head
import template.tags.Html

public fun Html._head(context: Context, vm: TechnicalDataVM) {
    head {
        cache(context=context, template=StaticHead, ref=::Head)
        title {
            +vm.seo.title
        }
        meta(name="description", content=vm.seo.description)
        meta(name="keywords", content=vm.seo.keywords)
        link(rel="canonical", href=vm.seo.canonicalUrl)
        if(vm.css.externalStylingPath.isNotEmpty())
            link(rel="stylesheet", href=vm.css.externalStylingPath)
        if(vm.css.inlineStyling.isNotEmpty())
            style {
                +vm.css.inlineStyling
            }
    }
}

private val StaticHead: StaticTemplateExtension<Head> =  { _, _ ->
    meta(charset="UTF-8")
    metaHttpEquiv(content="text/html; charset=UTF-8")
    meta(name="viewport", content="width=device-width, initial-scale=1")
}
