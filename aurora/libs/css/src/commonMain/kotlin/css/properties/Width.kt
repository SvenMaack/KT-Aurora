@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.WidthTextValue.auto

//https://www.w3schools.com/cssref/pr_dim_width.php

public interface WidthValue {
    public val value: String
}

public enum class WidthTextValue(public override val value: String): WidthValue {
    /**
     * The browser calculates the width. This is default.
     */
    auto("auto"),
}

/**
 * The width property sets the width of an element.
 */
public inline var Rule.width: WidthValue
    get() = auto
    set(width) {
        +Property(
            property = "width",
            value = width.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5
            )
        )
    }
