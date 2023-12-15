@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-basis.php

public interface FlexBasisValue {
    public val value: String
}

public enum class FlexBasisTextValue(public override val value: String): FlexBasisValue {
    /**
     * 	Default value. The length is equal to the length of the flexible item. If the item has no length specified, the length will be according to its content
     */
    auto("auto"),
}

/**
 * The flex-basis property specifies the initial length of a flexible item.
 */
public inline var Rule.`flex-basis`: Double
    get() = 0.0
    set(basis) {
        +Property(
            property = "flex-basis",
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
 * The flex-basis property specifies the initial length of a flexible item.
 */
public fun Rule.`flex-basis`(basis: FlexBasisValue) {
    +Property(
        property = "flex-basis",
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

