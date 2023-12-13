@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/css3_pr_border-radius.php

public enum class OpacityValue(public val value: String) {
    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

private val browserSupport = SupportData(
    chrome = 4.0,
    edge = 9.0,
    firefox = 2.0,
    safari = 3.1,
    opera = 9.0,
)

/**
 * The opacity property sets the opacity level for an element.
 */
public fun Rule.opacity(opacity: OpacityValue) {
    +Property(
        property = "opacity",
        value = opacity.value,
        supportedBrowsers = browserSupport
    )
}

/**
 * The opacity property sets the opacity level for an element.
 */
public fun Rule.opacity(opacity: Double) {
    +Property(
        property = "opacity",
        value = opacity.toString(),
        supportedBrowsers = browserSupport
    )
}
