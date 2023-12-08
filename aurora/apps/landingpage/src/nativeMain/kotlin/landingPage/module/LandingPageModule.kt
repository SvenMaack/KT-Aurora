package landingPage.module

import css.ResetDocument
import css.base.DocumentList
import css.base.IDocument
import landingPage.LandingPageDto
import head.HeadModule
import template.Template
import template.include
import template.tags.html
import navigation.NavigationModule
import page_lib.PageModule

private val landingPageTemplate: Template<LandingPageDto> = { context, data ->
    html(lang=context.language) {
        include(context=context, template=HeadModule.template, vm=data.technicalData)
        include(context=context, template=BodyTemplate, vm=data.navigation)
    }
}

private val landingPageDocument: IDocument = DocumentList().apply {
    +ResetDocument
    +NavigationModule.document
    +HeadModule.document
}

internal val landingPageModule: PageModule<LandingPageDto> =
    PageModule(landingPageDocument, landingPageTemplate)
