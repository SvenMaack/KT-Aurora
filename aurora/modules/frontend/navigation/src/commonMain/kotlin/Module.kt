package modules_lib.navigation

import css_lib.base.IDocument
import page_lib.DynamicModule
import template_lib.DynamicTemplate

val NavigationModule: DynamicModule<NavigationDto> = object : DynamicModule<NavigationDto> {
    override val document: IDocument = navigationCssDocument
    override val template: DynamicTemplate<NavigationDto> = NavigationTemplate
}

data class NavigationDto(
    val entries: List<String>
)
