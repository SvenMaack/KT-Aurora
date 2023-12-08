@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_Padding.php

private val support = SupportData(
    chrome = 1.0,
    edge = 4.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5,
)

public interface PaddingValue{
    public val value: String
}

public enum class PaddingTextValue(public override val value: String): PaddingValue {
    auto("auto"),
    initial("initial"),
    inherit("inherit"),
}

public class PaddingSize: Size, PaddingValue {
    override val value: String = toString()
}

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(value: PaddingValue) {
    +Property(
        property = "padding",
        value = value.toString(),
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(topBottom: PaddingValue, rightLeft: PaddingValue) {
    +Property(
        property = "padding",
        value = "$topBottom $rightLeft",
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(top: PaddingValue, rightLeft: PaddingValue, bottom: PaddingValue) {
    +Property(
        property = "padding",
        value = "$top $rightLeft $bottom",
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(top: PaddingValue, right: PaddingValue, bottom: PaddingValue, left: PaddingValue) {
    +Property(
        property = "padding",
        value = "$top $right $bottom $left",
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-block-start")
public fun Rule.`padding-top`(size: PaddingValue) {
    +Property(
        property = "padding-top",
        value = size.toString(),
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-inline-end")
public fun Rule.`padding-right`(value: PaddingValue) {
    +Property(
        property = "padding-right",
        value = value.value,
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-block-end")
public fun Rule.`padding-bottom`(value: PaddingValue) {
    +Property(
        property = "padding-bottom",
        value = value.value,
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-inline-start")
public fun Rule.`padding-left`(value: PaddingValue) {
    +Property(
        property = "padding-left",
        value = value.value,
        supportedBrowsers = support
    )
}







/**
 * The padding-block property specifies the Padding at the start and end in the block direction (Top, Down)
 */
public fun Rule.`padding-block-start`(value: PaddingValue) {
    +Property(
        property = "padding-block-start",
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

/**
 * The padding-block property specifies the Padding at the start and end in the block direction (Top, Down)
 */
public fun Rule.`padding-block-end`(value: PaddingValue) {
    +Property(
        property = "padding-block-end",
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

/**
 * The padding-block property specifies the Padding at the start and end in the block direction (Top, Down)
 */
public fun Rule.`padding-block`(start: PaddingValue, end: PaddingValue) {
    +Property(
        property = "padding-block",
        value = "$start $end",
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 66.0,
            safari = 14.1,
            opera = 73.0,
        )
    )
}

/**
 * The padding-inline property specifies the Padding at the start and end in the inline direction. (Left, Right)
 */
public fun Rule.`padding-inline-start`(value: PaddingValue) {
    +Property(
        property = "padding-inline-start",
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

/**
 * The padding-inline property specifies the Padding at the start and end in the inline direction. (Left, Right)
 */
public fun Rule.`padding-inline-end`(value: PaddingValue) {
    +Property(
        property = "padding-inline-end",
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

/**
 * The padding-inline property specifies the Padding at the start and end in the inline direction. (Left, Right)
 */
public fun Rule.`padding-inline`(start: PaddingValue, end: PaddingValue) {
    +Property(
        property = "padding-inline",
        value = "$start $end",
        supportedBrowsers = SupportData(
            chrome = 87.0,
            edge = 87.0,
            firefox = 66.0,
            safari = 14.1,
            opera = 73.0,
        )
    )
}
