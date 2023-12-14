@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public enum class TextDecorationValues(public val value: String) {
    none("none"),
    initial("initial"),
    inherit("inherit"),
}

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

public enum class LineHeightValue(public val value: String) {
    normal("normal"),
    initial("initial"),
    inherit("inherit")
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
 * The text-decoration property specifies the decoration added to text
 */
public fun Rule.`text-decoration`(style: TextDecorationValues) {
    +Property(
        property = "text-decoration",
        value = style.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 3.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 3.5,
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

/**
 * The line-height property specifies the height of a line.
 */
public fun Rule.`line-height`(size: Size) {
    +Property(
        property = "line-height",
        value = size.toString(),
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
 * The line-height property specifies the height of a line.
 */
public fun Rule.`line-height`(size: Double) {
    +Property(
        property = "line-height",
        value = size.toString(),
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
 * The line-height property specifies the height of a line.
 */
public fun Rule.`line-height`(size: LineHeightValue) {
    +Property(
        property = "line-height",
        value = size.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 7.0,
        )
    )
}
