@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.WidthTextValue.auto

//https://www.w3schools.com/cssref/pr_dim_max-width.php

/**
 * The max-width property sets the max-width of an element.
 */
public inline var Rule.`max-width`: WidthValue
    get() = auto
    set(width) {
        +Property(
            property = "max-width",
            value = width.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 7.0,
                firefox = 1.0,
                safari = 2.02,
                opera = 7.0,
            )
        )
    }

