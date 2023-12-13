@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_border-radius.php

private val browserSupport = SupportData(
    chrome = 5.0,
    edge = 9.0,
    firefox = 4.0,
    safari = 5.0,
    opera = 10.5,
)

/**
 * The border-radius property defines the radius of the element's corners.
 */
public fun Rule.`border-radius`(sizing: Size) {
    +Property(
        property = "border-radius",
        value = sizing.toString(),
        supportedBrowsers = browserSupport
    ).moz(SupportDataOverride(
        firefox = 3.0,
    )).webkit(SupportDataOverride(
        chrome = 4.0,
        safari = 3.1,
    ))
}

/**
 * The border-radius property defines the radius of the element's corners.
 */
public fun Rule.`border-radius`(topLeftBottomRight: Size, topRightBottomLeft: Size) {
    +Property(
        property = "border-radius",
        value = "$topLeftBottomRight $topRightBottomLeft",
        supportedBrowsers = browserSupport
    ).moz(SupportDataOverride(
        firefox = 3.0,
    )).webkit(SupportDataOverride(
        chrome = 4.0,
        safari = 3.1,
    ))
}

/**
 * The border-radius property defines the radius of the element's corners.
 */
public fun Rule.`border-radius`(topLeft: Size, topRightBottomLeft: Size, bottomRight: Size) {
    +Property(
        property = "border-radius",
        value = "$topLeft $topRightBottomLeft $bottomRight",
        supportedBrowsers = browserSupport
    ).moz(SupportDataOverride(
        firefox = 3.0,
    )).webkit(SupportDataOverride(
        chrome = 4.0,
        safari = 3.1,
    ))
}

/**
 * The border-radius property defines the radius of the element's corners.
 */
public fun Rule.`border-radius`(topLeft: Size, topRight: Size, bottomRight: Size, bottomLeft: Size) {
    +Property(
        property = "border-radius",
        value = "$topLeft $topRight $bottomRight $bottomLeft",
        supportedBrowsers = browserSupport
    ).moz(SupportDataOverride(
        firefox = 3.0,
    )).webkit(SupportDataOverride(
        chrome = 4.0,
        safari = 3.1,
    ))
}
