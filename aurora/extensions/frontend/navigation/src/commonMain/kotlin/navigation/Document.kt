package navigation

import basic.COLOR
import basic.TYPOGRAPHY
import basic._color
import basic._typography
import css.base.Document
import css.base.IDocument
import css.properties.*

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
        _color(COLOR.PRIMARY_2)
    }
    this[NAVIGATION__ITEM__ACTIVE] = {
        _color(COLOR.PRIMARY)
    }
}
