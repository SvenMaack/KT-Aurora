package landingPage.module

import css.base.DocumentList
import css.base.EmptyDocument
import css.base.IDocument
import landingPage.LandingPageDto
import modules_lib.navigation.NavigationModule
import page_lib.Module
import head.HeadModule
import template.Template
import template.include
import template.tags.enums.CountryCode.*
import template.tags.enums.GeneralLanguage.English
import template.tags.enums.minus
import template.tags.html

private val landingPageTemplate: Template<LandingPageDto> = { context, data ->
    html(lang=English-UNITED_STATES) {
        include(context=context, template=HeadModule.template, vm=data.head)
        include(context=context, template=BodyTemplate,        vm=data.navigation)
    }
}

private val landingPageDocument: IDocument = EmptyDocument

val LandingPageModule: Module<LandingPageDto> = object : Module<LandingPageDto> {
    override val document: IDocument = DocumentList()
        .add(landingPageDocument)
        .add(NavigationModule.document)
        .add(HeadModule.document)

    override val template: Template<LandingPageDto> =
        landingPageTemplate
}
