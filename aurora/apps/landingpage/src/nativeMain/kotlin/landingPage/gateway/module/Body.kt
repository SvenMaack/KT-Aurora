package landingPage.gateway.module

import css.base.DocumentList
import css.base.IDocument
import navigation.NavigationVM
import template.StaticTemplateExtension
import template.cache
import template.include
import template.tags.Html
import navigation.NavigationModule
import template.Context
import template.tags.Body

internal fun Html._body(context: Context, vm: NavigationVM) {
    body {
        include(template=NavigationModule.template, context=context, vm=vm)
        cache(template=StaticBody, context=context, ref=::Body)
    }
}

internal val BodyDocument: IDocument = DocumentList().apply {
    +NavigationModule.document
}

private val StaticBody: StaticTemplateExtension<Body> = { _, _ ->
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

