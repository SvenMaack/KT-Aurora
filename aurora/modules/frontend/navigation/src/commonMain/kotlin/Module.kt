package modules_lib.navigation

import css_lib.base.IDocument
import page_lib.Module
import template_lib.Template

val NavigationModule: Module<NavigationVM> = object : Module<NavigationVM> {
    override val document: IDocument = navigationCssDocument
    override val template: Template<NavigationVM> = NavigationTemplate
}

data class NavigationVM(
    val entries: List<String>
)
