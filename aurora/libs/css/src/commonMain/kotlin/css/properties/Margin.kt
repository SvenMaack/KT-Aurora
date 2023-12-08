package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/css_pr_margin-block.php

private val support = SupportData(
    chrome = 1.0,
    edge = 6.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5,
)

@Suppress("EnumEntryName", "EnumNaming")
public enum class MarginValue(public val value: String) {
    auto("auto"),
    initial("initial"),
    inherit("inherit"),
}


public fun Rule.margin(size: Size) {
    +Property(
        property = "margin",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.margin(topBottom: Size, rightLeft: Size) {
    +Property(
        property = "margin",
        value = "$topBottom $rightLeft",
        supportedBrowsers = support
    )
}

public fun Rule.margin(top: Size, rightLeft: Size, bottom: Size) {
    +Property(
        property = "margin",
        value = "$top $rightLeft $bottom",
        supportedBrowsers = support
    )
}

public fun Rule.margin(top: Size, right: Size, bottom: Size, left: Size) {
    +Property(
        property = "margin",
        value = "$top $right $bottom $left",
        supportedBrowsers = support
    )
}

public fun Rule.margin(value: MarginValue) {
    +Property(
        property = "margin",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.`margin-top`(size: Size) {
    +Property(
        property = "margin-top",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.`margin-top`(value: MarginValue) {
    +Property(
        property = "margin-top",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.`margin-right`(size: Size) {
    +Property(
        property = "margin-right",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.`margin-right`(value: MarginValue) {
    +Property(
        property = "margin-right",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.`margin-bottom`(size: Size) {
    +Property(
        property = "margin-bottom",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.`margin-bottom`(value: MarginValue) {
    +Property(
        property = "margin-bottom",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.`margin-left`(size: Size) {
    +Property(
        property = "margin-left",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.`margin-left`(value: MarginValue) {
    +Property(
        property = "margin-left",
        value = value.value,
        supportedBrowsers = support
    )
}



public fun Rule.`margin-block-start`(size: Size) {
    +Property(
        property = "margin-block-start",
        value = size.toString(),
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-block-start`(value: MarginValue) {
    +Property(
        property = "margin-block-start",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-block-end`(size: Size) {
    +Property(
        property = "margin-block-end",
        value = size.toString(),
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-block-end`(value: MarginValue) {
    +Property(
        property = "margin-block-end",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-block`(start: MarginValue, end: MarginValue) {
    +Property(
        property = "margin-block",
        value = "$start $end",
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-inline-start`(size: Size) {
    +Property(
        property = "margin-inline-start",
        value = size.toString(),
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-inline-start`(value: MarginValue) {
    +Property(
        property = "margin-inline-start",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-inline-end`(size: Size) {
    +Property(
        property = "margin-inline-end",
        value = size.toString(),
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-inline-end`(value: MarginValue) {
    +Property(
        property = "margin-inline-end",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}

public fun Rule.`margin-inline`(start: MarginValue, end: MarginValue) {
    +Property(
        property = "margin-inline",
        value = "$start $end",
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 41.0,
            safari = 12.1,
            opera = 73.0,
        )
    )
}
