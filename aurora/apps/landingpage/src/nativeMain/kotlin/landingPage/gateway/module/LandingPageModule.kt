package landingPage.gateway.module

import basic.BasicDocument
import css.ResetDocument
import css.base.DocumentList
import css.base.IDocument
import head.HeadDocument
import head._head
import landingPage.gateway.LandingPageVM
import template.Template
import template.tags.html

internal val LandingPageTemplate: Template<LandingPageVM> = { context, data ->
    html(lang=context.language) {
        _head(context=context, vm=data.technicalData)
        _body(context=context, vm=data.navigation)
    }
}

internal val LandingPageDocument: IDocument = DocumentList().apply {
    +ResetDocument
    +BasicDocument

    +HeadDocument
    +BodyDocument
}
