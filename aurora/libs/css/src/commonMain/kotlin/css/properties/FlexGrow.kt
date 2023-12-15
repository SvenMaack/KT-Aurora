@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-basis.php

public interface FlexGrowValue {
    public val value: String
}

/**
 * The flex-grow property specifies how much the item will grow relative to the rest of the flexible items inside the same container.
 */
public inline var Rule.`flex-grow`: Double
    get() = 0.0
    set(basis) {
        +Property(
            property = "flex-grow",
            value = basis.toString(),
            supportedBrowsers = SupportData(
                chrome = 29.0,
                edge = 11.0,
                firefox = 28.0,
                safari = 9.0,
                opera = 17.0,
            )
        ).webkit(SupportDataOverride(
            chrome = 21.0,
            safari = 6.1
        )).moz(SupportDataOverride(
            firefox = 18.0
        ))
    }

/**
 * The flex-grow property specifies how much the item will grow relative to the rest of the flexible items inside the same container.
 */
public fun Rule.`flex-grow`(basis: FlexGrowValue) {
    +Property(
        property = "flex-grow",
        value = basis.value,
        supportedBrowsers = SupportData(
            chrome = 29.0,
            edge = 11.0,
            firefox = 28.0,
            safari = 9.0,
            opera = 17.0,
        )
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}
