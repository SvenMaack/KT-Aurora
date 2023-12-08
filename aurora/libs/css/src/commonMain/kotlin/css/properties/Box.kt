@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportImpl

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

private val browserSupport = SupportImpl(
    chrome = { 4.0 },
    edge = { 8.0 },
    firefox = { 2.0 },
    safari = { 3.2 },
    opera = { 9.5 },
).supportedBrowsers

/**
 * The box-sizing property defines how the width and height of an element are calculated: should they include padding and borders, or not.
 */
public fun Rule.`box-sizing`(sizing: BoxSizingValue) {
    +Property(
        property = "-webkit-box-sizing",
        value = sizing.value,
        supportedBrowsers = browserSupport
    )
    +Property(
        property = "-moz-box-sizing",
        value = sizing.value,
        supportedBrowsers = browserSupport
    )
    +Property(
        property = "box-sizing",
        value = sizing.value,
        supportedBrowsers = browserSupport
    )
}