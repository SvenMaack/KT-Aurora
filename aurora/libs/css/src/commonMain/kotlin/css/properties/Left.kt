@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_pos_left.php

public fun Rule.left(value: PositionDistanceValue) {
    +Property(
        property = "left",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 5.5,
            firefox = 1.0,
            safari = 1.0,
            opera = 5.0,
        )
    )
}

public inline var Rule.left: Size
    get() = 0.px
    set(value) {
        +Property(
            property = "left",
            value = value.toString(),
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 5.5,
                firefox = 1.0,
                safari = 1.0,
                opera = 5.0,
            )
        )
    }
