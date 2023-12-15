@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/css3_pr_opacity.php

public interface OpacityValue {
    public val value: String
}

@PublishedApi internal inline fun Rule.opacity(opacity: String) {
    +Property(
        property = "opacity",
        value = opacity,
        supportedBrowsers = SupportData(
            chrome = 4.0,
            edge = 9.0,
            firefox = 2.0,
            safari = 3.1,
            opera = 9.0,
        )
    )
}


/**
 * The opacity property sets the opacity level for an element.
 */
public inline var Rule.opacity: Double
    get() = 1.0
    set(opacity) {
        this.opacity(opacity.toString())
    }

/**
 * The opacity property sets the opacity level for an element.
 */
public fun Rule.opacity(opacity: OpacityValue) {
    this.opacity(opacity.value)
}
