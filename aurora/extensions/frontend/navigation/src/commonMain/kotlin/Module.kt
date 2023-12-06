package modules_lib.navigation

import css.base.IDocument
import page_lib.Module
import template.TemplateExtension
import template.tags.BodyTagContainer

public val NavigationModule: Module<BodyTagContainer, NavigationVM> = object : Module<BodyTagContainer, NavigationVM> {
    override val document: IDocument = navigationCssDocument
    override val template: TemplateExtension<BodyTagContainer, NavigationVM> = NavigationTemplate
}

data class NavigationVM(
    val entries: List<String>
)
