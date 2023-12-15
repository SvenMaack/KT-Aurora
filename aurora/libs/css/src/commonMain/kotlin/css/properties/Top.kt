@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_pos_top.php

public interface PositionDistanceValue{
    public val value: String
}

public enum class PositionDistanceTextValue(public override val value: String): PositionDistanceValue {
    auto("auto")
}

public fun Rule.top(value: PositionDistanceValue) {
    +Property(
        property = "top",
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

public inline var Rule.top: Size
    get() = 0.px
    set(value) {
        +Property(
            property = "top",
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
