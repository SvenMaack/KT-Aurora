package modules_lib.navigation

import css_lib.base.Document
import css_lib.properties.margin
import css_lib.properties.px
import page_lib.DynamicModule
import template_lib.DynamicTemplate
import template_lib.childs
import template_lib.tags.Div

val NavigationModule: DynamicModule<NavigationDto> = object : DynamicModule<NavigationDto> {
    override val document: Document
        get() = navigationCssDocument
    override val template: DynamicTemplate<NavigationDto>
        get() = NavigationTemplate

}

data class NavigationDto(
    val entries: List<String>
)

internal val NavigationTemplate: DynamicTemplate<NavigationDto> = { _, data ->
    Div().childs {
        nav(clazz="navigation") {
            ul {
                data.entries.forEach { entry ->
                    li(clazz="navigation__item") {
                        span {
                            +entry
                        }
                    }
                }
            }
        }
    }
}

internal val navigationCssDocument: Document = Document().apply {
    this[".navigation"] = {
        margin(50.px)
    }
    this[".navigation__item"] = {
        margin(15.px)
    }
}
