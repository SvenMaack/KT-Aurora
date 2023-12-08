@file:Suppress("FunctionName", "MethodOverloading", "TooManyFunctions")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportImpl

//https://www.w3schools.com/cssref/pr_list-style.php

@Suppress("EnumEntryName", "EnumNaming")
public enum class ListStyleTypeValue(public val value: String) {
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

@Suppress("EnumEntryName", "EnumNaming")
public enum class ListStylePositionValue(public val value: String) {
    inside("inside"),
    outside("outside"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class ListStyleImageValue(public val value: String) {
    none("none"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class ListStyleValue(public val value: String) {
    initial("initial"),
    inherit("inherit"),
}

public fun Rule.`list-style-type`(style: ListStyleTypeValue): Property =
    +Property(
        property = "list-style-type",
        value = style.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 3.5 },
        ).supportedBrowsers
    )

public fun Rule.`list-style-position`(style: ListStylePositionValue): Property =
    +Property(
        property = "list-style-position",
        value = style.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 3.5 },
        ).supportedBrowsers
    )

public fun Rule.`list-style-image`(style: ListStyleImageValue): Property =
    +Property(
        property = "list-style-image",
        value = style.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )

public fun Rule.`list-style-image`(url: String): Property =
    +Property(
        property = "list-style-image",
        value = "url(\"$url\")",
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )

public fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue, image: ListStyleImageValue): Property =
    setListStyle(type, position, image.value)

public fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue, url: String): Property =
    setListStyle(type, position, "url(\"$url\")")

public fun Rule.`list-style`(position: ListStylePositionValue, image: ListStyleImageValue): Property =
    setListStyle(null, position, image.value)

public fun Rule.`list-style`(position: ListStylePositionValue, url: String): Property =
    setListStyle(null, position, "url(\"$url\")")

public fun Rule.`list-style`(type: ListStyleTypeValue, image: ListStyleImageValue): Property =
    setListStyle(type, null, image.value)

public fun Rule.`list-style`(type: ListStyleTypeValue, url: String): Property =
    setListStyle(type, null, "url(\"$url\")")

public fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue): Property =
    setListStyle(type, position, null)

public fun Rule.`list-style`(image: ListStyleImageValue): Property =
    setListStyle(null, null, image.value)

public fun Rule.`list-style`(url: String): Property =
    setListStyle(null, null, "url(\"$url\")")

public fun Rule.`list-style`(position: ListStylePositionValue): Property =
    setListStyle(null, position, null)

public fun Rule.`list-style`(type: ListStyleTypeValue): Property =
    setListStyle(type, null, null)


private fun Rule.setListStyle(type: ListStyleTypeValue?, position: ListStylePositionValue?, image: String?): Property =
    +Property(
        property = "list-style",
        value = "${type?.value ?: ""} ${position?.value ?: ""} ${image ?: ""}".replace("  ", " ").trim(),
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )
