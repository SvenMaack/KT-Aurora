package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_class_position.php

private val support = SupportData(
    chrome = 1.0,
    edge = 5.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 6.0,
)

@Suppress("EnumEntryName", "EnumNaming")
public enum class PositionValue(public val value: String) {
    static("static"),
    absolute("absolute"),
    fixed("fixed"),
    relative("relative"),
    sticky("sticky"),
    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class PositionDistanceValue(public val value: String) {
    initial("initial"),
    inherit("inherit"),
}

public fun Rule.position(position: PositionValue) {
    +Property(
        property = "position",
        value = position.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 7.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 4.0,
        )
    )
}

public fun Rule.top(size: Size) {
    +Property(
        property = "top",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.top(value: PositionDistanceValue) {
    +Property(
        property = "top",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.right(size: Size) {
    +Property(
        property = "right",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.right(value: PositionDistanceValue) {
    +Property(
        property = "right",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.bottom(size: Size) {
    +Property(
        property = "bottom",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.bottom(value: PositionDistanceValue) {
    +Property(
        property = "bottom",
        value = value.value,
        supportedBrowsers = support
    )
}

public fun Rule.left(size: Size) {
    +Property(
        property = "left",
        value = size.toString(),
        supportedBrowsers = support
    )
}

public fun Rule.left(value: PositionDistanceValue) {
    +Property(
        property = "left",
        value = value.value,
        supportedBrowsers = support
    )
}
