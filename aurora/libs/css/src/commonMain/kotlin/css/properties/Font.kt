@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_font_font.php

public interface FontValue {
    public val value: String
}

public enum class FontTextValue(public override val value: String): FontValue {
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
    `status-bar`("status-bar")
}

/**
 * Shorthand for the font properties.
 */
public fun Rule.font(
    style: FontStyleValue = FontStyleTextValue.normal,
    variant: FontVariantValue = FontVariantTextValue.normal,
    weight: FontWeightValue = FontWeightTextValue.normal,
    sizeValue: FontSizeValue = FontSizeTextValue.medium,
    lineHeightValue: LineHeightValue = LineHeightTextValue.normal,
    fontFamilyValue: FontFamilyValue = inherit,
) {
    +Property(
        property = "font",
        value = "${style.value} ${variant.value} ${weight.value} ${sizeValue.value}/${lineHeightValue.value} ${fontFamilyValue.value}",
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 3.5
        )
    )
}

/**
 * Shorthand for the font properties.
 */
public inline var Rule.font: FontValue
    get() = inherit
    set(font) {
        +Property(
            property = "font",
            value = font.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5
            )
        )
    }
