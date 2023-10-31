@file:Suppress("FunctionName")
package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Support
import css_lib.base.browser.SupportImpl

//https://www.w3schools.com/cssref/css_pr_padding-block.php

private val support = SupportImpl(
    chrome = { 1.0 },
    edge = { 6.0 },
    firefox = { 1.0 },
    safari = { 1.0 },
    opera = { 3.5 },
)

@Suppress("EnumEntryName")
enum class PaddingValue(val value: String) {
    auto("auto"),
    initial("initial"),
    inherit("inherit"),
}


fun Rule.padding(size: Size): Property =
    +object : Property("padding", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.padding(topBottom: Size, rightLeft: Size): Property =
    +object : Property("padding", "$topBottom $rightLeft"), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.padding(top: Size, rightLeft: Size, bottom: Size): Property =
    +object : Property("padding", "$top $rightLeft $bottom"), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.padding(top: Size, right: Size, bottom: Size, left: Size): Property =
    +object : Property("padding", "$top $right $bottom $left"), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.padding(value: PaddingValue): Property =
    +object : Property("padding", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-top`(size: Size): Property =
    +object : Property("padding-top", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-top`(value: PaddingValue): Property =
    +object : Property("padding-top", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-right`(size: Size): Property =
    +object : Property("padding-right", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-right`(value: PaddingValue): Property =
    +object : Property("padding-right", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-bottom`(size: Size): Property =
    +object : Property("padding-bottom", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-bottom`(value: PaddingValue): Property =
    +object : Property("padding-bottom", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-left`(size: Size): Property =
    +object : Property("padding-left", size.toString()), Support by support {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-left`(value: PaddingValue): Property =
    +object : Property("padding-left", value.value), Support by support {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-block-start`(size: Size): Property =
    +object : Property("padding-block-start", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-block-start`(value: PaddingValue): Property =
    +object : Property("padding-block-start", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-block-end`(size: Size): Property =
    +object : Property("padding-block-end", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-block-end`(value: PaddingValue): Property =
    +object : Property("padding-block-end", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-block`(start: PaddingValue, end: PaddingValue): Property =
    +object : Property("padding-block", "$start $end"), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 66.0 },
        safari = { 14.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "auto"
    }

fun Rule.`padding-inline-start`(size: Size): Property =
    +object : Property("padding-inline-start", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-inline-start`(value: PaddingValue): Property =
    +object : Property("padding-inline-start", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-inline-end`(size: Size): Property =
    +object : Property("padding-inline-end", size.toString()), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }
fun Rule.`padding-inline-end`(value: PaddingValue): Property =
    +object : Property("padding-inline-end", value.value), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 41.0 },
        safari = { 12.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "0"
    }

fun Rule.`padding-inline`(start: PaddingValue, end: PaddingValue): Property =
    +object : Property("padding-inline", "$start $end"), Support by SupportImpl(
        chrome = { 87.0 },
        edge = { 87.0 },
        firefox = { 66.0 },
        safari = { 14.1 },
        opera = { 73.0 },
    ) {
        override val defaultValue: String
            get() = "auto"
    }
