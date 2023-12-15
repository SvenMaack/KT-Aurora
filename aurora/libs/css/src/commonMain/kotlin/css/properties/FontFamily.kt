@file:Suppress("FunctionName", "TopLevelPropertyNaming", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_font_font-family.php

public interface FontFamilyValue {
    public val value: String
}

/**
 * The font-family property specifies the font for an element.
 */
public fun Rule.`font-family`(family: FontFamilyValue) {
    `font-family` = family.value
}

/**
 * The font-family property specifies the font for an element.
 */
public inline var Rule.`font-family`: String
    get() = ""
    set(family) {
        +Property(
            property = "font-family",
            value = family,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5
            )
        )
    }
