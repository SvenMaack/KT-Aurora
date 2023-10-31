@file:Suppress("FunctionName")

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
    +object : Property("list-style-type", style.value), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 4.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 3.5 },
    ) {
        override val defaultValue: String?
            get() = ListStyleTypeValue.disc.value
    }

fun Rule.`list-style-position`(style: ListStylePositionValue): Property =
    +object : Property("list-style-position", style.value), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 4.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 3.5 },
    ) {
        override val defaultValue: String?
            get() = ListStylePositionValue.outside.value
    }

fun Rule.`list-style-image`(style: ListStyleImageValue): Property =
    +object : Property("list-style-image", style.value), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 4.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 7.0 },
    ) {
        override val defaultValue: String?
            get() = ListStyleImageValue.none.value
    }

fun Rule.`list-style-image`(url: String): Property =
    +object : Property("list-style-image", url), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 4.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 7.0 },
    ) {
        override val defaultValue: String?
            get() = ListStyleImageValue.none.value
    }

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

fun Rule.`list-style`(style: ListStyleValue): Property =
    +object : Property("list-style", style.value), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 4.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 7.0 },
    ) {
        override val defaultValue: String?
            get() = ListStyleValue.initial.value
    }
