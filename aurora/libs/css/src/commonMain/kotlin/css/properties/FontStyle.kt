@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class FontStyleValue(public val value: String) {
    /**
     * The browser displays a normal font style. This is default.
     */
    normal("normal"),

    /**
     * The browser displays an italic font style
     */
    italic("italic"),

    /**
     * The browser displays an oblique font style
     */
    oblique("oblique"),

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
    opera = 7.0,
)

/**
 * The font-style property specifies the font style for a text.
 */
public fun Rule.`font-style`(style: FontStyleValue) {
    +Property(
        property = "font-style",
        value = style.value,
        supportedBrowsers = browserSupport
    )
}
