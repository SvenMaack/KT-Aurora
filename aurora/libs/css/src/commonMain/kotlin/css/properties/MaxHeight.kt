@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.HeightTextValue.auto

//https://www.w3schools.com/cssref/pr_dim_max-height.php

/**
 * The max-height property sets the max-height of an element.
 */
public inline var Rule.`max-height`: HeightValue
    get() = auto
    set(height) {
        +Property(
            property = "max-height",
            value = height.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 7.0,
                firefox = 1.0,
                safari = 2.02,
                opera = 7.0,
            )
        )
    }

