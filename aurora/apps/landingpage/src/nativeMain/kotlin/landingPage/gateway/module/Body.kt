package landingPage.gateway.module

import css.base.DocumentList
import css.base.IDocument
import navigation.NavigationDocument
import navigation.NavigationVM
import template.StaticTemplateExtension
import template.cache
import template.tags.Html
import navigation._navigation
import template.Context
import template.tags.Body

internal fun Html._body(context: Context, vm: NavigationVM) {
    body {
        _navigation(vm=vm)
        cache(template=StaticBody, context=context, ref=::Body)
    }
}

internal val BodyDocument: IDocument = DocumentList().apply {
    +NavigationDocument
}

private val StaticBody: StaticTemplateExtension<Body> = { _, _ ->
    main {
    }
    footer {
    }
}

