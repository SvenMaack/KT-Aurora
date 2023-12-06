package modules_lib.navigation

import page_lib.Module
import template.tags.BodyTagContainer

public val NavigationModule: Module<BodyTagContainer, NavigationVM> =
    Module(navigationCssDocument, NavigationTemplate)

data class NavigationVM(
    val entries: List<String>
)
