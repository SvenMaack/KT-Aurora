@file:Suppress("WrapUnaryOperator")
package navigation

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
import template.base.*

private val NAVIGATION: String = ClassGenerator()
private val NAVIGATION__ITEM: String = ClassGenerator()
private val NAVIGATION__ITEM__ACTIVE: String = ClassGenerator()

internal val NavigationTemplate: TemplateExtension<BodyTagContainer, NavigationVM> =  { _, vm ->
    nav {
        ul(clazz= NAVIGATION) {
            vm.entries.forEach {
                li("class"[NAVIGATION__ITEM, NAVIGATION__ITEM__ACTIVE%it.active]) {
                    span {
                        +it.name
                    }
                }
            }
        }
    }
}

internal val NavigationDocument: IDocument = Document().apply {
    this[NAVIGATION] = {
        position(absolute)
        top(50.percentage)
        left(50.percentage)
        transform2D(Translate(-50.percentage, -50.percentage))
        `list-style-type`(none)
    }
    this[NAVIGATION__ITEM] = {
        `text-transform`(uppercase)
        display(`inline-block`)
        padding(15.px)
    }
}
