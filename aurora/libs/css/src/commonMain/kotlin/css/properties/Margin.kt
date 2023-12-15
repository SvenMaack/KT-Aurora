@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_margin.php

private val support = SupportData(
    chrome = 1.0,
    edge = 6.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5,
)

public interface MarginValue {
    public val value: String
}

public enum class MarginTextValue(public override val value: String): MarginValue {
    auto("auto")
}

/**
 * The margin property sets the margins for an element
 */
public inline var Rule.margin: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 6.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The margin property sets the margins for an element
 */
public fun Rule.margin(topBottom: MarginValue, rightLeft: MarginValue) {
    +Property(
        property = "margin",
        value = "${topBottom.value} ${rightLeft.value}",
        supportedBrowsers = support
    )
}

/**
 * The margin property sets the margins for an element
 */
public fun Rule.margin(top: MarginValue, rightLeft: MarginValue, bottom: MarginValue) {
    +Property(
        property = "margin",
        value = "${top.value} ${rightLeft.value} ${bottom.value}",
        supportedBrowsers = support
    )
}

/**
 * The margin property sets the margins for an element
 */
public fun Rule.margin(top: MarginValue, right: MarginValue, bottom: MarginValue, left: MarginValue) {
    +Property(
        property = "margin",
        value = "${top.value} ${right.value} ${bottom.value} ${left.value}",
        supportedBrowsers = support
    )
}

/**
 * The margin property sets the margins for an element
 */
@Deprecated("use margin-block-start")
public inline var Rule.`margin-top`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-top",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 6.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The margin property sets the margins for an element
 */
@Deprecated("use margin-inline-end")
public inline var Rule.`margin-right`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-right",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 6.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The margin property sets the margins for an element
 */
@Deprecated("use margin-block-end")
public inline var Rule.`margin-bottom`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-bottom",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 6.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The margin property sets the margins for an element
 */
@Deprecated("use margin-inline-start")
public inline var Rule.`margin-left`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-left",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 6.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }

/**
 * The margin-block property specifies the margin at the start and end in the block direction (Top, Down)
 */
public inline var Rule.`margin-block-start`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-block-start",
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
 * The margin-block property specifies the margin at the start and end in the block direction (Top, Down)
 */
public inline var Rule.`margin-block-end`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-block-end",
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
 * The margin-block property specifies the margin at the start and end in the block direction (Top, Down)
 */
public fun Rule.`margin-block`(start: MarginValue, end: MarginValue) {
    +Property(
        property = "margin-block",
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
 * The margin-block property specifies the margin at the start and end in the block direction (Top, Down)
 */
public inline var Rule.`margin-block`: MarginValue
    get() = inherit
    set(block) {
        +Property(
            property = "margin-block",
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
 * The margin-inline property specifies the margin at the start and end in the inline direction. (Left, Right)
 */
public inline var Rule.`margin-inline-start`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-inline-start",
            value = value.value,
            supportedBrowsers = SupportData(
                chrome = 69.0,
                edge = 79.0,
                firefox = 68.0,
                safari = 14.1,
                opera = 56.0,
            )
        )
    }

/**
 * The margin-inline property specifies the margin at the start and end in the inline direction. (Left, Right)
 */
public inline var Rule.`margin-inline-end`: MarginValue
    get() = 0.px
    set(value) {
        +Property(
            property = "margin-inline-end",
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
 * The margin-inline property specifies the margin at the start and end in the inline direction. (Left, Right)
 */
public fun Rule.`margin-inline`(start: MarginValue, end: MarginValue) {
    +Property(
        property = "margin-inline",
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
 * The margin-inline property specifies the margin at the start and end in the inline direction. (Left, Right)
 */
public inline var Rule.`margin-inline`: MarginValue
    get() = inherit
    set(inline) {
        +Property(
            property = "margin-inline",
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
