package navigation

import basic.COLOR.PRIMARY
import basic.COLOR.PRIMARY_2
import basic.TYPOGRAPHY.BUTTON
import basic.*
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
        `padding-block-end` = _rem(5)
        `margin-inline` = _rem(20)
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
