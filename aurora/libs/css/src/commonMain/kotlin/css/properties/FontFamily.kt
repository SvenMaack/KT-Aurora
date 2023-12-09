@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class FontFamilyValue(public val value: String) {
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
    chrome = 1.0,
    edge = 4.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5
)

/**
 * The font-family property specifies the font for an element.
 */
public fun Rule.`font-family`(value: FontFamilyValue) {
    +Property(
        property = "font-family",
        value = value.value,
        supportedBrowsers = browserSupport
    )
}

/**
 * The font-family property specifies the font for an element.
 */
public fun Rule.`font-family`(value: String) {
    +Property(
        property = "font-family",
        value = value,
        supportedBrowsers = browserSupport
    )
}
