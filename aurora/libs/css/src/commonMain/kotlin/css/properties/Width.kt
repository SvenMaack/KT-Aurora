@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride

//https://www.w3schools.com/cssref/pr_dim_Width.php

public interface WidthValue {
    public val value: String
}

public enum class WidthTextValue(public override val value: String): WidthValue {
    /**
     * The browser calculates the Width. This is default.
     */
    auto("auto"),

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
    chrome = 1.0,
    edge = 4.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5,
)

/**
 * The Width property sets the Width of an element.
 */
public fun Rule.width(width: WidthValue) {
    +Property(
        property = "width",
        value = width.value,
        supportedBrowsers = browserSupport
    )
}

/**
 * The min-Width property defines the minimum Width of an element.
 */
public fun Rule.`min-width`(width: WidthValue) {
    +Property(
        property = "min-width",
        value = width.value,
        supportedBrowsers = browserSupport + SupportDataOverride(
            edge = 7.0,
            firefox = 3.0,
            safari = 2.02,
            opera = 4.0
        )
    )
}

/**
 * The max-Width property defines the maximum Width of an element.
 */
public fun Rule.`max-width`(width: WidthValue) {
    +Property(
        property = "max-width",
        value = width.value,
        supportedBrowsers = browserSupport + SupportDataOverride(
            edge = 7.0,
            safari = 2.02,
            opera = 7.0
        )
    )
}
