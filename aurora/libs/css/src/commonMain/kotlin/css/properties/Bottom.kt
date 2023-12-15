@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_pos_bottom.php

public fun Rule.bottom(value: PositionDistanceValue) {
    +Property(
        property = "bottom",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 5.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 6.0,
        )
    )
}

public inline var Rule.bottom: Size
    get() = 0.px
    set(value) {
        +Property(
            property = "bottom",
            value = value.toString(),
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 5.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 6.0,
            )
        )
    }
