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
import css.properties.margin
import css.properties.px

//<editor-fold desc="Tags">
private val html = Tag("html")
private val body = Tag("body")
private val h1 = Tag("h1")
private val h2 = Tag("h2")
private val h3 = Tag("h3")
private val h4 = Tag("h3")
private val h5 = Tag("h3")
private val p = Tag("p")
private val figure = Tag("figure")
private val blockquote = Tag("blockquote")
private val dl = Tag("dl")
private val dd = Tag("dd")
//</editor-fold>

public val ResetDocument: IDocument = Document().apply {
    /* Box sizing rules */
    this[html] = {
        `box-sizing`(`border-box`)
    }
    this[UNIVERSAL, UNIVERSAL..BEFORE, UNIVERSAL..AFTER] = {
        `box-sizing`(inherit)
    }
    /* Remove default margin */
    this[body, h1, h2, h3, h4, h5, p, figure, blockquote, dl, dd] = {
        margin(0.px)
    }
}
