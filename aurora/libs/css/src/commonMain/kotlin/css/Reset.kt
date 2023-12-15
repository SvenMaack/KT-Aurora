@file:Suppress("MagicNumber")
package css

import css.base.*
import css.properties.*
import css.properties.BoxSizingTextValue.`border-box`
import css.properties.DisplayTypeTextValue.block
import css.properties.ListStyleTypeTextValue.none
import css.properties.ScrollBehaviourTextValue.smooth
import css.properties.TextRenderingTextValue.optimizeSpeed

public val ResetDocument: IDocument = Document().apply {
    /* Box sizing rules */
    tag["html"] = {
        `box-sizing` = `border-box`
    }
    tag["*"] = {
        `box-sizing` = inherit
        before {
            `box-sizing` = inherit
        }
        after {
            `box-sizing` = inherit
        }
    }
    /* Remove default margin */
    tag["body", "h1", "h2", "h3", "h4", "h5", "p", "figure", "blockquote", "dl", "dd"] = {
        margin = 0.px
    }
    /* Remove list styles on ul, ol elements with a list role, which suggests default styling will be removed */
    this[
        Attribute(Tag("ol"), "role", "list"),
        Attribute(Tag("ul"), "role", "list"),
    ] = {
        `list-style` = none
    }
    /* Set core root defaults */
    tag["html"] = {
        focusWithin {
            `scroll-behavior` = smooth
        }
    }
    /* Set core body defaults */
    tag["body"] = {
        `min-height` = 100.vh
        `text-rendering` = optimizeSpeed
        `line-height` = 1.5
    }
    /* Make images easier to work with */
    tag["img", "picture"] = {
        `max-width` = 100.percentage
        display = block
    }
    /* Inherit fonts for inputs and buttons */
    tag["input", "button", "textarea", "select"] = {
        font = inherit
    }
}
