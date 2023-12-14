package navigation

import basic.COLOR.PRIMARY
import basic.COLOR.PRIMARY_2
import basic.TYPOGRAPHY.BUTTON
import basic.`_background-color`
import basic._color
import basic._typography
import css.base.*
import css.base.PseudoValues.AFTER
import css.base.PseudoValues.HOVER
import css.properties.*
import css.properties.ColorTextValue.inherit
import css.properties.DisplayTypeValue.`inline-block`
import css.properties.PositionValue.absolute
import css.properties.PositionValue.relative
import css.properties.TextDecorationValues.none

public val NavigationDocument: IDocument = Document().apply {
    this[NAVIGATION] = {
        position(absolute)
        top(50.percentage)
        left(50.percentage)
        transform2D(Translate((-50).percentage, (-50).percentage))
        `list-style-type`(ListStyleTypeValue.none)
    }
    this[NAVIGATION__ITEM] = {
        _color(PRIMARY_2)
        _typography(BUTTON)
        display(`inline-block`)
        `padding-block-end`((5/16).rem)
        margin(0.px, (20/16).rem)
        position(relative)
    }
    this[
        Class(NAVIGATION__ITEM)..HOVER,
        Class(NAVIGATION__ITEM__ACTIVE)
    ] = {
        _color(PRIMARY)
    }
    this[Class(NAVIGATION__ITEM__ACTIVE)..AFTER] = {
        content("\"\"")
        width(40.percentage)
        height(2.px)
        position(absolute)
        bottom(0.px)
        left(0.px)
        `_background-color`(PRIMARY)
    }
    /* Inherit fonts for inputs and buttons */
    this[NAVIGATION__ITEM_TEXT] = {
        color(inherit)
        `text-decoration`(none)
    }
}
