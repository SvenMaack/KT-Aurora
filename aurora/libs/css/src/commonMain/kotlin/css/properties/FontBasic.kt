@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_font_font.php

public enum class FontValue(public val value: String) {
    /**
     * Uses the font that are used by captioned controls (like buttons, drop-downs, etc.)
     */
    caption("caption"),

    /**
     * Uses the font that are used by icon labels
     */
    icon("icon"),

    /**
     * Uses the fonts that are used by dropdown menus
     */
    menu("menu"),

    /**
     * Uses the fonts that are used by dialog boxes
     */
    `message-box`("message-box"),

    /**
     * A smaller version of the caption font
     */
    `small-caption`("small-caption"),

    /**
     * Uses the fonts that are used by the status bar
     */
    `status-bar`("status-bar"),

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
 * Shorthand for the font properties.
 */
public fun Rule.font(
    style: FontStyleValue = FontStyleValue.normal,
    variant: FontVariantValue = FontVariantValue.normal,
    weight: FontWeightValue = FontWeightValue.normal,
    sizeValue: FontSizeValue = FontSizeValue.medium,
    lineHeightValue: LineHeightValue = LineHeightValue.normal,
    fontFamilyValue: FontFamilyValue = FontFamilyValue.inherit,
) {
    +Property(
        property = "font",
        value = "$style $variant $weight $sizeValue/$lineHeightValue $fontFamilyValue",
        supportedBrowsers = browserSupport
    )
}

/**
 * Shorthand for the font properties.
 */
public fun Rule.font(font: FontValue) {
    +Property(
        property = "font",
        value = font.value,
        supportedBrowsers = browserSupport
    )
}
