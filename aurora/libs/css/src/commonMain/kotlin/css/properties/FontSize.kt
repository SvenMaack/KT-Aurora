@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class FontSizeValue(public val value: String) {
    /**
     * Sets the font-size to a medium size. This is default
     */
    medium("medium"),

    /**
     * 	Sets the font-size to an xx-small size
     */
    `xx-small`("xx-small"),

    /**
     * 	Sets the font-size to an extra small size
     */
    `x-small`("x-small"),

    /**
     * 	Sets the font-size to a small size
     */
    small("small"),

    /**
     * Sets the font-size to a large size
     */
    large("large"),

    /**
     *	Sets the font-size to an extra large size
     */
    `x-large`("x-large"),

    /**
     * Sets the font-size to an xx-large size
     */
    `xx-large`("medium"),

    /**
     * Sets the font-size to a smaller size than the parent element
     */
    smaller("smaller"),

    /**
     * Sets the font-size to a larger size than the parent element
     */
    larger("larger"),

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
    edge = 5.5,
    firefox = 1.0,
    safari = 1.0,
    opera = 7.0
)

/**
 * The font-size property sets the size of a font.
 */
public fun Rule.`font-size`(size: Size) {
    +Property(
        property = "font-size",
        value = size.toString(),
        supportedBrowsers = browserSupport
    )
}

/**
 * The font-size property sets the size of a font.
 */
public fun Rule.`font-size`(value: FontSizeValue) {
    +Property(
        property = "font-size",
        value = value.value,
        supportedBrowsers = browserSupport
    )
}
