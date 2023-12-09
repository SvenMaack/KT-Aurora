@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class FontWeightValue(public val value: String) {
    /**
     * Defines normal characters. This is default
     */
    normal("normal"),

    /**
     * Defines thick characters
     */
    bold("bold"),

    /**
     * Defines thicker characters
     */
    bolder("bold"),

    /**
     * 	Defines lighter characters
     */
    lighter("bold"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `100`("100"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `200`("200"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `300`("300"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `400`("400"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `500`("500"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `600`("600"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `700`("700"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `800`("800"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `900`("900"),

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
    chrome = 2.0,
    edge = 4.0,
    firefox = 1.0,
    safari = 1.3,
    opera = 3.5
)

/**
 * The font-weight property sets how thick or thin characters in text should be displayed.
 */
public fun Rule.`font-weight`(weight: FontWeightValue) {
    +Property(
        property = "font-weight",
        value = weight.value,
        supportedBrowsers = browserSupport
    )
}
