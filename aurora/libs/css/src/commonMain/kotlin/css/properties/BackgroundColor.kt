@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_background-color.php

/**
 * The color property specifies the background-color of text.
 */
public inline var Rule.`background-color`: ColorValue
    get() = ColorTextValue.transparent
    set(color) {
        +Property(
            property = "background-color",
            value = color.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 3.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }
