package landingPage.module

import css.base.IDocument
import landingPage.LandingPageDto
import head.HeadModule
import template.Template
import template.include
import template.tags.enums.CountryCode.*
import template.tags.enums.GeneralLanguage.English
import template.tags.enums.minus
import template.tags.html
import modules_lib.navigation.NavigationModule
import page_lib.PageModule

private val landingPageTemplate: Template<LandingPageDto> = { context, data ->
    html(lang=English-UNITED_STATES) {
        include(context=context, template=HeadModule.template, vm=data.head)
        include(context=context, template=BodyTemplate, vm=data.navigation)
    }
}

private val landingPageDocument: IDocument = NavigationModule.document

internal val landingPageModule: PageModule<LandingPageDto> = object : PageModule<LandingPageDto> {
    override val document: IDocument = landingPageDocument
    override val template: Template<LandingPageDto> = landingPageTemplate
}

