package landingPage.module

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

private val landingPageDocument: IDocument = NavigationModule.document

internal val landingPageModule: PageModule<LandingPageDto> =
    PageModule(landingPageDocument, landingPageTemplate)
