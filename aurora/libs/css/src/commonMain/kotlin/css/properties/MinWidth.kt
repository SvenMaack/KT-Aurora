@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.WidthTextValue.auto

//https://www.w3schools.com/cssref/pr_dim_min-width.php

/**
 * The min-width property sets the min-width of an element.
 */
public inline var Rule.`min-width`: WidthValue
    get() = auto
    set(width) {
        +Property(
            property = "min-width",
            value = width.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 7.0,
                firefox = 1.0,
                safari = 2.02,
                opera = 4.0,
            )
        )
    }
