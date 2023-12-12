package landingPage.gateway.module

import css.ResetDocument
import css.base.DocumentList
import css.base.IDocument
import head.HeadModule
import landingPage.gateway.LandingPageVM
import template.Template
import template.include
import template.tags.html
import page.PageModule

private val landingPageTemplate: Template<LandingPageVM> = { context, data ->
    html(lang=context.language) {
        include(context=context, template=HeadModule.template, vm=data.technicalData)
        include(context=context, template=BodyModule.template, vm=data.navigation)
    }
}

private val landingPageDocument: IDocument = DocumentList().apply {
    +ResetDocument
    +HeadModule.document
    +BodyModule.document
}

internal val LandingPageModule: PageModule<LandingPageVM> =
    PageModule(landingPageDocument, landingPageTemplate)
