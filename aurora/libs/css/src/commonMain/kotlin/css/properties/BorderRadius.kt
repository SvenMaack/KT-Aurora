@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_border-radius.php

public interface BorderRadiusValue {
    public val value: String
}

@PublishedApi internal inline fun Rule.`border-radius`(sizing: String) {
    +Property(
        property = "border-radius",
        value = sizing,
        supportedBrowsers = SupportData(
            chrome = 5.0,
            edge = 9.0,
            firefox = 4.0,
            safari = 5.0,
            opera = 10.5,
        )
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
public inline var Rule.`border-radius`: BorderRadiusValue
    get() = 0.px
    set(border) {
        this.`border-radius`(border.value)
    }

/**
 * The border-radius property defines the radius of the element's corners.
 */
public inline fun Rule.`border-radius`(topLeftBottomRight: Size, topRightBottomLeft: Size) {
    this.`border-radius`("$topLeftBottomRight $topRightBottomLeft")
}

/**
 * The border-radius property defines the radius of the element's corners.
 */
public inline fun Rule.`border-radius`(topLeft: Size, topRightBottomLeft: Size, bottomRight: Size) {
    this.`border-radius`("$topLeft $topRightBottomLeft $bottomRight")
}

/**
 * The border-radius property defines the radius of the element's corners.
 */
public inline fun Rule.`border-radius`(topLeft: Size, topRight: Size, bottomRight: Size, bottomLeft: Size) {
    this.`border-radius`("$topLeft $topRight $bottomRight $bottomLeft")
}
