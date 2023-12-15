package basic

import css.base.Document
import css.base.IDocument

public val BasicDocument: IDocument = Document().apply {
    tag["html"] = {
        _color = COLOR.TEXT
        `_background-color` = COLOR.BACKGROUND
    }
}
