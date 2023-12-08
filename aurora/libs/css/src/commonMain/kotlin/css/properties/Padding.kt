@file:Suppress("FunctionName", "MethodOverloading", "TooManyFunctions")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportImpl

//https://www.w3schools.com/cssref/css_pr_padding-block.php

private val support = SupportImpl(
    chrome = { 1.0 },
    edge = { 6.0 },
    firefox = { 1.0 },
    safari = { 1.0 },
    opera = { 3.5 },
)

@Suppress("EnumEntryName", "EnumNaming")
public enum class PaddingValue(public val value: String) {
    auto("auto"),
    initial("initial"),
    inherit("inherit"),
}


public fun Rule.padding(size: Size): Property =
    +Property(
        property = "padding",
        value = size.toString(),
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.padding(topBottom: Size, rightLeft: Size): Property =
    +Property(
        property = "padding",
        value = "$topBottom $rightLeft",
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.padding(top: Size, rightLeft: Size, bottom: Size): Property =
    +Property(
        property = "padding",
        value = "$top $rightLeft $bottom",
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.padding(top: Size, right: Size, bottom: Size, left: Size): Property =
    +Property(
        property = "padding",
        value = "$top $right $bottom $left",
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.padding(value: PaddingValue): Property =
    +Property(
        property = "padding",
        value = value.value,
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-top`(size: Size): Property =
    +Property(
        property = "padding-top",
        value = size.toString(),
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-top`(value: PaddingValue): Property =
    +Property(
        property = "padding-top",
        value = value.value,
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-right`(size: Size): Property =
    +Property(
        property = "padding-right",
        value = size.toString(),
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-right`(value: PaddingValue): Property =
    +Property(
        property = "padding-right",
        value = value.value,
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-bottom`(size: Size): Property =
    +Property(
        property = "padding-bottom",
        value = size.toString(),
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-bottom`(value: PaddingValue): Property =
    +Property(
        property = "padding-bottom",
        value = value.value,
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-left`(size: Size): Property =
    +Property(
        property = "padding-left",
        value = size.toString(),
        supportedBrowsers = support.supportedBrowsers
    )

public fun Rule.`padding-left`(value: PaddingValue): Property =
    +Property(
        property = "padding-left",
        value = value.value,
        supportedBrowsers = support.supportedBrowsers
    )



public fun Rule.`padding-block-start`(size: Size): Property =
    +Property(
        property = "padding-block-start",
        value = size.toString(),
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-block-start`(value: PaddingValue): Property =
    +Property(
        property = "padding-block-start",
        value = value.value,
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-block-end`(size: Size): Property =
    +Property(
        property = "padding-block-end",
        value = size.toString(),
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-block-end`(value: PaddingValue): Property =
    +Property(
        property = "padding-block-end",
        value = value.value,
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-block`(start: PaddingValue, end: PaddingValue): Property =
    +Property(
        property = "padding-block",
        value = "$start $end",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 66.0 },
            safari = { 14.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-inline-start`(size: Size): Property =
    +Property(
        property = "padding-inline-start",
        value = size.toString(),
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-inline-start`(value: PaddingValue): Property =
    +Property(
        property = "padding-inline-start",
        value = value.value,
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-inline-end`(size: Size): Property =
    +Property(
        property = "padding-inline-end",
        value = size.toString(),
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-inline-end`(value: PaddingValue): Property =
    +Property(
        property = "padding-inline-end",
        value = value.value,
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

public fun Rule.`padding-inline`(start: PaddingValue, end: PaddingValue): Property =
    +Property(
        property = "padding-inline",
        value = "$start $end",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 66.0 },
            safari = { 14.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )
