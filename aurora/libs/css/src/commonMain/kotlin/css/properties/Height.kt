@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.HeightTextValue.auto

//https://www.w3schools.com/cssref/pr_dim_height.php

public interface HeightValue {
    public val value: String
}

public enum class HeightTextValue(public override val value: String): HeightValue {
    /**
     * The browser calculates the height. This is default.
     */
    auto("auto"),
}

/**
 * The height property sets the height of an element.
 */
public inline var Rule.height: HeightValue
    get() = auto
    set(height) {
        +Property(
            property = "height",
            value = height.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5
            )
        )
    }
