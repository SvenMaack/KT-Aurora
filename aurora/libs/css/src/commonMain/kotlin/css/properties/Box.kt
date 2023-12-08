@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_box-sizing.php

public enum class BoxSizingValue(public val value: String) {
    /**
     * 	Default. The width and height properties (and min/max properties) includes only the content. Border and padding are not included
     */
    `content-box`("content-box"),

    /**
     * 	The width and height properties (and min/max properties) includes content, padding and border
     */
    `border-box`("border-box"),

    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

public enum class SpecialBoxSizingValue(public val value: String) {
    /**
     * 	The width and height properties (and min/max properties) includes content and padding but no border.
     */
    `padding-box`("padding-box"),
}

private val browserSupport = SupportData(
    chrome = 10.0,
    edge = 8.0,
    firefox = 29.0,
    safari = 5.1,
    opera = 9.5,
)

/**
 * The box-sizing property defines how the width and height of an element are calculated: should they include padding and borders, or not.
 */
public fun Rule.`box-sizing`(sizing: BoxSizingValue) {
    +Property(
        property = "box-sizing",
        value = sizing.value,
        supportedBrowsers = browserSupport
    ).moz(SupportDataOverride(
        firefox = 2.0,
    )).webkit(SupportDataOverride(
        chrome = 4.0,
        safari = 3.2,
    ))
}

/**
 * The box-sizing property defines how the width and height of an element are calculated: should they include padding and borders, or not.
 */
public fun Rule.`box-sizing`(sizing: SpecialBoxSizingValue) {
    +Property(
        property = "box-sizing",
        value = sizing.value,
        supportedBrowsers = SupportData(firefox = 49.0)
    )
}
