@file:Suppress("WrapUnaryOperator")
package modules_lib.navigation

import css.base.Document
import css.base.IDocument
import css.properties.*
import css.properties.DisplayTypeValue.`inline-block`
import css.properties.ListStyleTypeValue.*
import css.properties.PositionValue.absolute
import css.properties.TextTransformValues.uppercase
import page_lib.ClassGenerator
import template.TemplateExtension
import template.tags.BodyTagContainer

private val NAVIGATION: String = ClassGenerator("nav")
private val NAVIGATION__ITEM: String = ClassGenerator("nav")


internal val NavigationTemplate: TemplateExtension<BodyTagContainer, NavigationVM> =  { _, data ->
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
