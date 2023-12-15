@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
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
}

public class PaddingSize: Size, PaddingValue {
    override val value: String = toString()
}

/**
 * The padding property sets the Paddings for an element
 */
public inline var Rule.padding: PaddingValue
    get() = 0.px
    set(value) {
        +Property(
            property = "padding",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(topBottom: PaddingValue, rightLeft: PaddingValue) {
    +Property(
        property = "padding",
        value = "${topBottom.value} ${rightLeft.value}",
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(top: PaddingValue, rightLeft: PaddingValue, bottom: PaddingValue) {
    +Property(
        property = "padding",
        value = "${top.value} ${rightLeft.value} ${bottom.value}",
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
public fun Rule.padding(top: PaddingValue, right: PaddingValue, bottom: PaddingValue, left: PaddingValue) {
    +Property(
        property = "padding",
        value = "${top.value} ${right.value} ${bottom.value} ${left.value}",
        supportedBrowsers = support
    )
}

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-block-start")
public inline var Rule.`padding-top`: PaddingValue
    get() = 0.px
    set(size) {
        +Property(
            property = "padding-top",
            value = size.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-inline-end")
public inline var Rule.`padding-right`: PaddingValue
    get() = 0.px
    set(value) {
        +Property(
            property = "padding-right",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-block-end")
public inline var Rule.`padding-bottom`: PaddingValue
    get() = 0.px
    set(value) {
        +Property(
            property = "padding-bottom",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The padding property sets the Paddings for an element
 */
@Deprecated("use padding-inline-start")
public inline var Rule.`padding-left`: PaddingValue
    get() = 0.px
    set(value) {
        +Property(
            property = "padding-left",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The padding-block property specifies the Padding at the start and end in the block direction (Top, Down)
 */
public inline var Rule.`padding-block-start`: PaddingValue
    get() = 0.px
    set(value) {
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
public inline var Rule.`padding-block-end`: PaddingValue
    get() = 0.px
    set(value) {
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
        value = "${start.value} ${end.value}",
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
 * The padding-block property specifies the Padding at the start and end in the block direction (Top, Down)
 */
public inline var Rule.`padding-block`: PaddingValue
    get() = inherit
    set(block) {
        +Property(
            property = "padding-block",
            value = block.value,
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
public inline var Rule.`padding-inline-start`: PaddingValue
    get() = 0.px
    set(value) {
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
public inline var Rule.`padding-inline-end`: PaddingValue
    get() = 0.px
    set(value) {
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
        value = "${start.value} ${end.value}",
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
public inline var Rule.`padding-inline`: PaddingValue
    get() = inherit
    set(inline) {
        +Property(
            property = "padding-inline",
            value = inline.value,
            supportedBrowsers = SupportData(
                chrome = 87.0,
                edge = 87.0,
                firefox = 66.0,
                safari = 14.1,
                opera = 73.0,
            )
        )
    }
