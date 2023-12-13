package navigation

import basic.COLOR
import basic.TYPOGRAPHY
import basic._color
import basic._typography
import css.base.Document
import css.base.IDocument
import css.properties.CursorValue
import css.properties.DisplayTypeValue
import css.properties.ListStyleTypeValue
import css.properties.PositionValue
import css.properties.Translate
import css.properties.cursor
import css.properties.display
import css.properties.left
import css.properties.`list-style-type`
import css.properties.padding
import css.properties.percentage
import css.properties.position
import css.properties.px
import css.properties.top
import css.properties.transform2D

public val NavigationDocument: IDocument = Document().apply {
    this[NAVIGATION] = {
        position(PositionValue.absolute)
        top(50.percentage)
        left(50.percentage)
        transform2D(Translate((-50).percentage, (-50).percentage))
        `list-style-type`(ListStyleTypeValue.none)
    }
    this[NAVIGATION__ITEM] = {
        _typography(TYPOGRAPHY.BUTTON)
        display(DisplayTypeValue.`inline-block`)
        padding(15.px)
        cursor(CursorValue.POINTER)
        _color(COLOR.PRIMARY_4)
    }
    this[NAVIGATION__ITEM__ACTIVE] = {
        _color(COLOR.PRIMARY)
    }
}
