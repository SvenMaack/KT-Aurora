@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-shrink.php

public interface FlexShrinkValue {
    public val value: String
}

/**
 * The flex-shrink property specifies how the item will shrink relative to the rest of the flexible items inside the same container.
 */
public inline var Rule.`flex-shrink`: Double
    get() = 0.0
    set(basis) {
        +Property(
            property = "flex-shrink",
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
 * The flex-shrink property specifies how the item will shrink relative to the rest of the flexible items inside the same container.
 */
public fun Rule.`flex-shrink`(basis: FlexShrinkValue) {
    +Property(
        property = "flex-shrink",
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
