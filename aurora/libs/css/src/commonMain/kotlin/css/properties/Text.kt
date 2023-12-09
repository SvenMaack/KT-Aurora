@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class TextTransformValues(public val value: String) {
    none("none"),
    capitalize("capitalize"),
    uppercase("uppercase"),
    lowercase("lowercase"),
    initial("initial"),
    inherit("inherit"),
}

public enum class TextRenderingValues(public val value: String) {
    auto("auto"),
    optimizeSpeed("optimizeSpeed"),
    optimizeLegibility("optimizeLegibility")
}

/**
 * The text-transform property controls the capitalization of text.
 */
public fun Rule.`text-transform`(style: TextTransformValues) {
    +Property(
        property = "text-transform",
        value = style.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 7.0,
        )
    )
}

/**
 * The text-rendering CSS property provides information to the rendering engine about what to optimize for when rendering text.
 */
public fun Rule.`text-rendering`(style: TextRenderingValues) {
    +Property(
        property = "text-rendering",
        value = style.value,
        supportedBrowsers = SupportData(
            chrome = 4.0,
            edge = 79.0,
            firefox = 1.0,
            safari = 5.0,
            opera = 15.0,
        )
    )
}
