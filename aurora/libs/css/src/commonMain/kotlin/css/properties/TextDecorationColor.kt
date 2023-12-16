@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_text-decoration-color.php

public interface TextDecorationColorValue {
    public val value: String
}

@PublishedApi internal inline fun Rule.`text-decoration-color`(decoration: TextDecorationColorValue) {
    +Property(
        property = "text-decoration-color",
        value = decoration.value,
        supportedBrowsers = SupportData(
            chrome = 57.0,
            edge = 79.0,
            firefox = 36.0,
            safari = 12.1,
            opera = 44.0,
        )
    ).moz(SupportDataOverride(
        firefox = 6.0,
    )).webkit(SupportDataOverride(
        safari = 7.1,
    ))
}

/**
 * The border-radius property defines the radius of the element's corners.
 */
public inline var Rule.`text-decoration-color`: ColorValue
    get() = ColorTextValue.transparent
    set(color) {
        +Property(
            property = "text-decoration-color",
            value = color.value,
            supportedBrowsers = SupportData(
                chrome = 57.0,
                edge = 79.0,
                firefox = 36.0,
                safari = 12.1,
                opera = 44.0,
            )
        ).moz(SupportDataOverride(
            firefox = 6.0,
        )).webkit(SupportDataOverride(
            safari = 7.1,
        ))
    }
