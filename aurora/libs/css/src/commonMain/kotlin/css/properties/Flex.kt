@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex.php

public interface FlexValue {
    public val value: String
}

public enum class FlexTextValue(public override val value: String): FlexValue {
    /**
     * Same as 1 1 auto.
     */
    auto("auto"),
}

private val browserSupport = SupportData(
    chrome = 29.0,
    edge = 11.0,
    firefox = 28.0,
    safari = 9.0,
    opera = 17.0,
)

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexGrowValue, shrink: FlexShrinkValue, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "${grow.value} ${shrink.value} ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexGrowValue, shrink: FlexShrinkValue, basis: Double) {
    +Property(
        property = "flex",
        value = "${grow.value} ${shrink.value} $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexGrowValue, shrink: Double, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "${grow.value} $shrink ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: FlexShrinkValue, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "$grow ${shrink.value} ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: Double, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "$grow $shrink ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexGrowValue, shrink: Double, basis: Double) {
    +Property(
        property = "flex",
        value = "${grow.value} $shrink $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: FlexShrinkValue, basis: Double) {
    +Property(
        property = "flex",
        value = "$grow ${shrink.value} $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: Double, basis: Double) {
    +Property(
        property = "flex",
        value = "$grow $shrink $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(basis: FlexValue) {
    +Property(
        property = "flex",
        value = basis.value,
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}
