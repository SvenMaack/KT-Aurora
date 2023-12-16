@file:Suppress("WrapUnaryOperator")
package navigation

import basic.*
import css.base.*
import css.properties.*
import basic.COLOR.PRIMARY
import basic.COLOR.PRIMARY_2
import basic.TYPOGRAPHY.BUTTON
import css.properties.DisplayTypeTextValue.`inline-block`
import css.properties.ListStyleTypeTextValue.none
import css.properties.PositionTextValue.absolute
import css.properties.PositionTextValue.relative

public val NavigationDocument: IDocument = Document().apply {
    clazz[NAVIGATION] = {
        _center()
        `list-style-type` = none
    }
    clazz[NAVIGATION__ITEM] = {
        position = relative
        display = `inline-block`
        `margin-inline` = _rem(20)
        `padding-block-end` = _rem(5)
        _color = PRIMARY_2
        _typography = BUTTON
        hover {
            _color = PRIMARY
        }
    }
    clazz[NAVIGATION__ITEM__ACTIVE] = {
        _color = PRIMARY
        after {
            position = absolute
            bottom = `0`
            left = `0`
            width = 40.percentage
            height = 2.px
            `_background-color` = PRIMARY
        }
    }
}
