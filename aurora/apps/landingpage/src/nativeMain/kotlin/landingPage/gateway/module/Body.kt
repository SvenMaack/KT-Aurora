package landingPage.gateway.module

import navigation.NavigationVM
import template.StaticTemplateExtension
import template.TemplateExtension
import template.cache
import template.include
import template.tags.Html
import navigation.NavigationModule
import page.Module
import template.tags.Body

private val BodyTemplate: TemplateExtension<Html, NavigationVM> = { context, data ->
    body {
        include(template=NavigationModule.template, context=context, vm=data)
        cache(template=Example, context=context, ref=::Body)
    }
}

private val Example: StaticTemplateExtension<Body> = { _, _ ->
    main {
        div(clazz="MyClass") {
            p(clazz="test") {
                +"This is my first kotlin rendered page"
            }
        }
    }
    footer {
    }
}

internal val BodyModule: Module<Html, NavigationVM> =
    Module(NavigationModule.document, BodyTemplate)
