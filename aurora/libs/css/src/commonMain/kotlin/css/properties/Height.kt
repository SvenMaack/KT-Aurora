@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride

//https://www.w3schools.com/cssref/pr_dim_height.php

public interface HeightValue {
    public val value: String
}

public enum class HeightTextValue(public override val value: String): HeightValue {
    /**
     * The browser calculates the height. This is default.
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
    opera = 7.0,
)

/**
 * The height property sets the height of an element.
 */
public fun Rule.height(height: HeightValue) {
    +Property(
        property = "height",
        value = height.value,
        supportedBrowsers = browserSupport
    )
}

/**
 * The min-height property defines the minimum height of an element.
 */
public fun Rule.`min-height`(height: HeightValue) {
    +Property(
        property = "min-height",
        value = height.value,
        supportedBrowsers = browserSupport + SupportDataOverride(
            edge = 7.0,
            firefox = 3.0,
            safari = 2.02,
            opera = 4.0
        )
    )
}

/**
 * The max-height property defines the maximum height of an element.
 */
public fun Rule.`max-height`(height: HeightValue) {
    +Property(
        property = "max-height",
        value = height.value,
        supportedBrowsers = browserSupport + SupportDataOverride(
            edge = 7.0,
            safari = 2.02,
        )
    )
}
