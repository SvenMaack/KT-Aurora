@file:Suppress("FunctionName", "unused")
package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.SupportImpl

//https://www.w3schools.com/cssref/css_pr_margin-block.php

private val support = SupportImpl(
    chrome = { 1.0 },
    edge = { 6.0 },
    firefox = { 1.0 },
    safari = { 1.0 },
    opera = { 3.5 },
)

@Suppress("EnumEntryName")
enum class MarginValue(val value: String) {
    auto("auto"),
    initial("initial"),
    inherit("inherit"),
}


fun Rule.margin(size: Size): Property =
    +Property.build(
        property = "margin",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.margin(topBottom: Size, rightLeft: Size): Property =
    +Property.build(
        property = "margin",
        value = "$topBottom $rightLeft",
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.margin(top: Size, rightLeft: Size, bottom: Size): Property =
    +Property.build(
        property = "margin",
        value = "$top $rightLeft $bottom",
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.margin(top: Size, right: Size, bottom: Size, left: Size): Property =
    +Property.build(
        property = "margin",
        value = "$top $right $bottom $left",
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.margin(value: MarginValue): Property =
    +Property.build(
        property = "margin",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-top`(size: Size): Property =
    +Property.build(
        property = "margin-top",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-top`(value: MarginValue): Property =
    +Property.build(
        property = "margin-top",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-right`(size: Size): Property =
    +Property.build(
        property = "margin-right",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-right`(value: MarginValue): Property =
    +Property.build(
        property = "margin-right",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-bottom`(size: Size): Property =
    +Property.build(
        property = "margin-bottom",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-bottom`(value: MarginValue): Property =
    +Property.build(
        property = "margin-bottom",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-left`(size: Size): Property =
    +Property.build(
        property = "margin-left",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )

fun Rule.`margin-left`(value: MarginValue): Property =
    +Property.build(
        property = "margin-left",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = support.supportedBrowsers
    )



fun Rule.`margin-block-start`(size: Size): Property =
    +Property.build(
        property = "margin-block-start",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-block-start`(value: MarginValue): Property =
    +Property.build(
        property = "margin-block-start",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-block-end`(size: Size): Property =
    +Property.build(
        property = "margin-block-end",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-block-end`(value: MarginValue): Property =
    +Property.build(
        property = "margin-block-end",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-block`(start: MarginValue, end: MarginValue): Property =
    +Property.build(
        property = "margin-block",
        value = "$start $end",
        defaultValue = "auto",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 66.0 },
            safari = { 14.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-inline-start`(size: Size): Property =
    +Property.build(
        property = "margin-inline-start",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-inline-start`(value: MarginValue): Property =
    +Property.build(
        property = "margin-inline-start",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-inline-end`(size: Size): Property =
    +Property.build(
        property = "margin-inline-end",
        value = size.toString(),
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-inline-end`(value: MarginValue): Property =
    +Property.build(
        property = "margin-inline-end",
        value = value.value,
        defaultValue = "0",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 41.0 },
            safari = { 12.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )

fun Rule.`margin-inline`(start: MarginValue, end: MarginValue): Property =
    +Property.build(
        property = "margin-inline",
        value = "$start $end",
        defaultValue = "auto",
        supportedBrowsers = SupportImpl(
            chrome = { 87.0 },
            edge = { 87.0 },
            firefox = { 66.0 },
            safari = { 14.1 },
            opera = { 73.0 },
        ) .supportedBrowsers
    )
