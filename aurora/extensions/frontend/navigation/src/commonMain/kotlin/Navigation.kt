@file:Suppress("WrapUnaryOperator")
package modules_lib.navigation

import css.base.Document
import css.base.IDocument
import css.properties.*
import css.properties.DisplayTypeValue.`inline-block`
import css.properties.ListStyleTypeValue.*
import css.properties.PositionValue.absolute
import css.properties.TextTransformValues.uppercase
import template.Template
import template.childs
import template.tags.Div
import page_lib.ClassGenerator

private val NAVIGATION: String = ClassGenerator("nav")
private val NAVIGATION__ITEM: String = ClassGenerator("nav")

internal val NavigationTemplate: Template<NavigationVM> = { _, data ->
    Div().apply {
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
    }.childs()
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