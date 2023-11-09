@file:Suppress("WrapUnaryOperator")

package modules_lib.navigation

import css_lib.base.Document
import css_lib.base.IDocument
import css_lib.properties.*
import css_lib.properties.DisplayTypeValue.`inline-block`
import css_lib.properties.ListStyleTypeValue.*
import css_lib.properties.PositionValue.absolute
import css_lib.properties.TextTransformValues.uppercase
import page_lib.DynamicModule
import template_lib.DynamicTemplate
import template_lib.childs
import template_lib.tags.Div

val NavigationModule: DynamicModule<NavigationDto> = object : DynamicModule<NavigationDto> {
    override val document: IDocument
        get() = navigationCssDocument
    override val template: DynamicTemplate<NavigationDto>
        get() = NavigationTemplate

}

data class NavigationDto(
    val entries: List<String>
)

internal val NavigationTemplate: DynamicTemplate<NavigationDto> = { _, data ->
    Div().childs {
        nav {
            ul(clazz="navigation") {
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

internal val navigationCssDocument: IDocument = Document().apply {
    this["navigation"] = {
        position(absolute)
        top(50.percentage)
        left(50.percentage)
        transform(-50.percentage, -50.percentage)
        `list-style-type`(none)
    }
    this["navigation__item"] = {
        `text-transform`(uppercase)
        display(`inline-block`)
        padding(15.px)
    }
}
