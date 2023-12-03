package modules_lib.navigation

import css.base.IDocument
import page_lib.Module
import template.Template

val NavigationModule: Module<NavigationVM> = object : Module<NavigationVM> {
    override val document: IDocument = navigationCssDocument
    override val template: Template<NavigationVM> = NavigationTemplate
}

data class NavigationVM(
    val entries: List<String>
)
