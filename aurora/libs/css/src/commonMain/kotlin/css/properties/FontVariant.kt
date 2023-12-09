@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class FontVariantValue(public val value: String) {
    /**
     * The browser displays a normal font. This is default
     */
    normal("normal"),

    /**
     * The browser displays a small-caps font
     */
    `small-caps`("small-caps"),

    /**
     * Sets this property to its default value
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

private val browserSupport = SupportData(
    chrome = 10.0,
    edge = 4.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5
)

/**
 * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
 */
public fun Rule.`font-variant`(variant: FontVariantValue) {
    +Property(
        property = "font-variant",
        value = variant.value,
        supportedBrowsers = browserSupport
    )
}

