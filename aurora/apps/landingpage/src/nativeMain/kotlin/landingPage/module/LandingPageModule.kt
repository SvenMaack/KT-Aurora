package landingPage.module

import css_lib.base.DocumentList
import css_lib.base.EmptyDocument
import css_lib.base.IDocument
import landingPage.LandingPageDto
import modules_lib.navigation.NavigationModule
import page_lib.DynamicModule
import page_lib.SimpleHeadTemplate
import template_lib.DynamicTemplate
import template_lib.include
import template_lib.tags.html

private val landingPageTemplate: DynamicTemplate<LandingPageDto> = { context, data ->
    html(lang="en") {
        include(context=context, template=SimpleHeadTemplate, dto=data.head)
        include(context=context, template=BodyTemplate,       dto=data.navigation)
    }
}

private val landingPageDocument: IDocument = EmptyDocument

val LandingPageModule: DynamicModule<LandingPageDto> = object : DynamicModule<LandingPageDto> {
    override val document: IDocument = DocumentList()
        .add(landingPageDocument)
        .add(NavigationModule.document)

    override val template: DynamicTemplate<LandingPageDto> =
        landingPageTemplate
}
