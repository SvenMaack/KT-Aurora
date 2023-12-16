@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_text_text-decoration.php

public interface TextDecorationValue {
    public val value: String
}

/**
 * The text-decoration property specifies the decoration added to text, and is a shorthand property
 */
public inline var Rule.`text-decoration`: TextDecorationValue
    get() = inherit
    set(color) {
        +Property(
            property = "text-decoration",
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

/**
 * The text-decoration property specifies the decoration added to text, and is a shorthand property
 */
public inline fun Rule.`text-decoration`(
    line: TextDecorationLineValue,
    color: TextDecorationColorValue,
    style: TextDecorationStyleValue,
    thickness: TextDecorationThicknessValue,
) {
    +Property(
        property = "text-decoration",
        value = "${line.value} ${color.value} ${style.value} ${thickness.value}".trim().replace("  ", " "),
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 3.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 3.5,
        )
    )
}
