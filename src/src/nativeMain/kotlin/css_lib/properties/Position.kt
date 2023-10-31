package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Support
import css_lib.base.browser.SupportImpl

//https://www.w3schools.com/cssref/pr_class_position.php

private val support = SupportImpl(
    chrome = { 1.0 },
    edge = { 5.0 },
    firefox = { 1.0 },
    safari = { 1.0 },
    opera = { 6.0 },
)

@Suppress("EnumEntryName")
enum class PositionValue(val value: String) {
    static("static"),
    absolute("absolute"),
    fixed("fixed"),
    relative("relative"),
    sticky("sticky"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName")
enum class PositionDistanceValue(val value: String) {
    initial("initial"),
    inherit("inherit"),
}

fun Rule.position(position: PositionValue): Property =
    +object : Property("position", position.value), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 7.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 4.0 },
    ) {
        override val defaultValue: String
            get() = PositionValue.static.value
    }

fun Rule.top(size: Size): Property =
    +object : Property("top", size.toString()), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }
fun Rule.top(value: PositionDistanceValue): Property =
    +object : Property("top", value.value), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }

fun Rule.right(size: Size): Property =
    +object : Property("right", size.toString()), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }
fun Rule.right(value: PositionDistanceValue): Property =
    +object : Property("right", value.value), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }

fun Rule.bottom(size: Size): Property =
    +object : Property("bottom", size.toString()), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }
fun Rule.bottom(value: PositionDistanceValue): Property =
    +object : Property("bottom", value.value), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }

fun Rule.left(size: Size): Property =
    +object : Property("left", size.toString()), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }
fun Rule.left(value: PositionDistanceValue): Property =
    +object : Property("left", value.value), Support by support {
        override val defaultValue: String
            get() = PositionValue.static.value
    }
