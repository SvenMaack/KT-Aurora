package css

import css.base.Document
import css.base.IDocument
import css.base.UNIVERSAL
import css.properties.BoxSizingValue.*
import css.properties.`box-sizing`

public val ResetDocument: IDocument = Document().apply {
    /* Box sizing rules */
    this[UNIVERSAL] = {
        `box-sizing`(`border-box`)
    }
}