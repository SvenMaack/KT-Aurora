package navigation

import basic.COLOR.PRIMARY
import basic.COLOR.PRIMARY_2
import basic.TYPOGRAPHY.BUTTON
import basic.`_background-color`
import basic._color
import basic._typography
import css.base.*
import css.properties.*
import css.properties.DisplayTypeTextValue.`inline-block`
import css.properties.ListStyleTypeTextValue.none
import css.properties.PositionTextValue.absolute
import css.properties.PositionTextValue.relative

public val NavigationDocument: IDocument = Document().apply {
    clazz[NAVIGATION] = {
        position = absolute
        top = 50.percentage
        left = 50.percentage
        transform = Translate((-50).percentage, (-50).percentage)
        `list-style-type` = none
    }
    clazz[NAVIGATION__ITEM] = {
        _color = PRIMARY_2
        _typography = BUTTON
        display = `inline-block`
        `padding-block-end` = (5/16).rem
        `margin-inline` = (20/16).rem
        position = relative
        hover {
            _color = PRIMARY
        }
    }
    clazz[NAVIGATION__ITEM__ACTIVE] = {
        _color = PRIMARY
        after {
            width = 40.percentage
            height = 2.px
            position = absolute
            bottom = 0.px
            left = 0.px
            `_background-color` = PRIMARY
        }
    }
    clazz[NAVIGATION__ITEM_TEXT] = {
        color = inherit
        //`text-decoration`(none)
    }
}
