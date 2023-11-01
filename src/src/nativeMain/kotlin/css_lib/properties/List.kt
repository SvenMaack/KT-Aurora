@file:Suppress("FunctionName", "unused")

package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Support
import css_lib.base.browser.SupportImpl

//https://www.w3schools.com/cssref/pr_list-style.php

@Suppress("EnumEntryName")
enum class ListStyleTypeValue(val value: String) {
    disc("disc"),
    armenian("armenian"),
    circle("circle"),
    `cjk-ideographic`("cjk-ideographic"),
    decimal("decimal"),
    `decimal-leading-zero`("decimal-leading-zero"),
    georgian("georgian"),
    hebrew("hebrew"),
    hiragana("hiragana"),
    `hiragana-iroha`("hiragana-iroha"),
    katakana("katakana"),
    `katakana-iroha`("katakana-iroha"),
    `lower-alpha`("lower-alpha"),
    `lower-greek`("lower-greek"),
    `lower-latin`("lower-latin"),
    `lower-roman`("lower-roman"),
    none("none"),
    square("square"),
    `upper-alpha`("upper-alpha"),
    `upper-greek`("upper-greek"),
    `upper-latin`("upper-latin"),
    `upper-roman`("upper-roman"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName")
enum class ListStylePositionValue(val value: String) {
    inside("inside"),
    outside("outside"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName")
enum class ListStyleImageValue(val value: String) {
    none("none"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName")
enum class ListStyleValue(val value: String) {
    initial("initial"),
    inherit("inherit"),
}

fun Rule.`list-style-type`(style: ListStyleTypeValue): Property =
    +Property.build(
        property = "list-style-type",
        value = style.value,
        defaultValue = ListStyleTypeValue.disc.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 3.5 },
        ).supportedBrowsers
    )

fun Rule.`list-style-position`(style: ListStylePositionValue): Property =
    +Property.build(
        property = "list-style-position",
        value = style.value,
        defaultValue = ListStylePositionValue.outside.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 3.5 },
        ).supportedBrowsers
    )

fun Rule.`list-style-image`(style: ListStyleImageValue): Property =
    +Property.build(
        property = "list-style-image",
        value = style.value,
        defaultValue = ListStyleImageValue.none.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )

fun Rule.`list-style-image`(url: String): Property =
    +Property.build(
        property = "list-style-image",
        value = url,
        defaultValue = ListStyleImageValue.none.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )

fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue, image: ListStyleImageValue): Property {
    `list-style-position`(position)
    `list-style-image`(image)
    return `list-style-type`(type)
}

fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue, image: String): Property {
    `list-style-position`(position)
    `list-style-image`(image)
    return `list-style-type`(type)
}
