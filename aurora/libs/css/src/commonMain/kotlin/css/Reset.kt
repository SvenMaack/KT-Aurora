package css

import css.base.Document
import css.base.IDocument
import css.base.PseudoValues.AFTER
import css.base.PseudoValues.BEFORE
import css.base.Tag
import css.base.UNIVERSAL
import css.base.rangeTo
import css.properties.BoxSizingValue.*
import css.properties.`box-sizing`

private val html = Tag("html")

public val ResetDocument: IDocument = Document().apply {
    /* Box sizing rules */
    this[html] = {
        `box-sizing`(`border-box`)
    }
    this[UNIVERSAL, UNIVERSAL..BEFORE, UNIVERSAL..AFTER] = {
        `box-sizing`(inherit)
    }
}
