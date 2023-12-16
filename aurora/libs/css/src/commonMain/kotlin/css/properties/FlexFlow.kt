@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-flow.php

/**
 * The flex-flow property is a shorthand property.
 */
public fun Rule.`flex-flow`(direction: FlexDirectionValue, wrap: FlexWrapValue) {
    +Property(
        property = "flex-flow",
        value = "${direction.value} ${wrap.value}",
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

