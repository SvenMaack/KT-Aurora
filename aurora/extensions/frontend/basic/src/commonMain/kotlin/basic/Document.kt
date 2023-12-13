package basic

import css.base.Document
import css.base.IDocument
import css.base.html

public val BasicDocument: IDocument = Document().apply {
    this[html] = {
        _color(COLOR.TEXT)
        `_background-color`(COLOR.BACKGROUND)
    }
}
