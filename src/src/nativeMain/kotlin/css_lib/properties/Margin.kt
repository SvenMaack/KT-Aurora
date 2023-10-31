@file:Suppress("FunctionName")
package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Support
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
    +object : Property("margin", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.margin(topBottom: Size, rightLeft: Size): Property =
    +object : Property("margin", "$topBottom $rightLeft"), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.margin(top: Size, rightLeft: Size, bottom: Size): Property =
    +object : Property("margin", "$top $rightLeft $bottom"), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.margin(top: Size, right: Size, bottom: Size, left: Size): Property =
    +object : Property("margin", "$top $right $bottom $left"), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.margin(value: MarginValue): Property =
    +object : Property("margin", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-top`(size: Size): Property =
    +object : Property("margin-top", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-top`(value: MarginValue): Property =
    +object : Property("margin-top", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-right`(size: Size): Property =
    +object : Property("margin-right", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-right`(value: MarginValue): Property =
    +object : Property("margin-right", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-bottom`(size: Size): Property =
    +object : Property("margin-bottom", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-bottom`(value: MarginValue): Property =
    +object : Property("margin-bottom", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-left`(size: Size): Property =
    +object : Property("margin-left", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-left`(value: MarginValue): Property =
    +object : Property("margin-left", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-block-start`(size: Size): Property =
    +object : Property("margin-block-start", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-block-start`(value: MarginValue): Property =
    +object : Property("margin-block-start", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-block-end`(size: Size): Property =
    +object : Property("margin-block-end", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-block-end`(value: MarginValue): Property =
    +object : Property("margin-block-end", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-block`(start: MarginValue, end: MarginValue): Property =
    +object : Property("margin-block", "$start $end"), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 66.0 },
        safari = { 14.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "auto"
    }

fun Rule.`margin-inline-start`(size: Size): Property =
    +object : Property("margin-inline-start", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-inline-start`(value: MarginValue): Property =
    +object : Property("margin-inline-start", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-inline-end`(size: Size): Property =
    +object : Property("margin-inline-end", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`margin-inline-end`(value: MarginValue): Property =
    +object : Property("margin-inline-end", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`margin-inline`(start: MarginValue, end: MarginValue): Property =
    +object : Property("margin-inline", "$start $end"), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 66.0 },
        safari = { 14.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "auto"
    }
