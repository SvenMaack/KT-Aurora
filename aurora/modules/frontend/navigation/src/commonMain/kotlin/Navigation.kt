@file:Suppress("WrapUnaryOperator")
package modules_lib.navigation

import css_lib.base.Document
import css_lib.base.IDocument
import css_lib.properties.*
import css_lib.properties.DisplayTypeValue.`inline-block`
import css_lib.properties.ListStyleTypeValue.*
import css_lib.properties.PositionValue.absolute
import css_lib.properties.TextTransformValues.uppercase
import template_lib.DynamicTemplate
import template_lib.childs
import template_lib.tags.Div
import page_lib.ClassGenerator

private val NAVIGATION: String = ClassGenerator("nav")
private val NAVIGATION__ITEM: String = ClassGenerator("nav")

internal val NavigationTemplate: DynamicTemplate<NavigationDto> = { _, data ->
    Div().childs {
        nav {
            ul(clazz=NAVIGATION) {
                data.entries.forEach { entry ->
                    li(clazz=NAVIGATION__ITEM) {
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
    this[NAVIGATION] = {
        position(absolute)
        top(50.percentage)
        left(50.percentage)
        transform(-50.percentage, -50.percentage)
        `list-style-type`(none)
    }
    this[NAVIGATION__ITEM] = {
        `text-transform`(uppercase)
        display(`inline-block`)
        padding(15.px)
    }
}
