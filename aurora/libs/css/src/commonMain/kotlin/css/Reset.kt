package css

import css.base.*
import css.base.PseudoValues.AFTER
import css.base.PseudoValues.BEFORE
import css.base.PseudoValues.FOCUS_WITHIN
import css.properties.*
import css.properties.BoxSizingValue.*
import css.properties.DisplayTypeValue.block
import css.properties.ListStyleImageValue.none
import css.properties.ScrollBehaviour.smooth
import css.properties.TextRenderingValues.optimizeSpeed
import css.properties.FontValue.inherit as fontInherit

@Suppress("MagicNumber")
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
    /* Remove list styles on ul, ol elements with a list role, which suggests default styling will be removed */
    this[Attribute("ol", "role", "list"), Attribute("ul", "role", "list")] = {
        `list-style`(none)
    }
    /* Set core root defaults */
    this[html..FOCUS_WITHIN] = {
        `scroll-behavior`(smooth)
    }
    /* Set core body defaults */
    this[body] = {
        `min-height`(100.vh)
        `text-rendering`(optimizeSpeed)
        `line-height`(1.5)
    }
    /* Make images easier to work with */
    this[img, picture] = {
        `max-width`(100.percentage)
        display(block)
    }
    /* Inherit fonts for inputs and buttons */
    this[input, button, textarea, select] = {
        font(fontInherit)
    }
}
