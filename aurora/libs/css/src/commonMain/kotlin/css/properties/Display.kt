@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.NOT_SUPPORTED
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.webkit

//https://www.w3schools.com/cssref/pr_class_display.php

@Suppress("EnumEntryName", "EnumNaming")
public enum class DisplayTypeValue(public val value: String) {
    /**
     * 	Displays an element as an inline element (like <span>). Any height and width properties will have no effect
     */
    @Suppress("UnnecessaryBackticks")
    `inline`("inline"),

    /**
     * Displays an element as a block element (like <p>). It starts on a new line, and takes up the whole width
     */
    block("block"),

    /**
     * 	Displays an element as a block-level grid container
     */
    grid("grid"),

    /**
     * Displays an element as an inline-level block container. The element itself is formatted as an inline element, but you can apply height and width values
     */
    `inline-block`("inline-block"),

    /**
     *Displays an element as an inline-level grid container
     */
    `inline-grid`("inline-grid"),

    @Deprecated("use grid instead")
    /**
     * The element is displayed as an inline-level table
     */
    `inline-table`("inline-table"),

    /**
     * Let the element behave like a <li> element
     */
    `list-item`("list-item"),

    /**
     * Displays an element as either block or inline, depending on context
     */
    `run-in`("run-in"),
    @Deprecated("use grid instead")
    table("table"),
    @Deprecated("use grid instead")
    `table-caption`("table-caption"),
    @Deprecated("use grid instead")
    `table-column-group`("table-column-group"),
    @Deprecated("use grid instead")
    `table-header-group`("table-header-group"),
    @Deprecated("use grid instead")
    `table-footer-group`("table-footer-group"),
    @Deprecated("use grid instead")
    `table-row-group`("table-row-group"),
    @Deprecated("use grid instead")
    `table-cell`("table-cell"),
    @Deprecated("use grid instead")
    `table-column`("table-column"),
    @Deprecated("use grid instead")
    `table-row`("table-row"),

    /**
     * The element is completely removed
     */
    none("none"),

    /**
     * Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element
     */
    inherit("inherit"),
    unset("unset")
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class DisplayTypeValuesWithPrefix(public val value: String) {
    /**
     * Displays an element as a block-level flex container
     */
    flex("flex"),

    /**
     * Displays an element as an inline-level flex container
     */
    `inline-flex`("inline-flex"),
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class ModernDisplayTypeValues(public val value: String) {
    /**
     * Makes the container disappear, making the child elements children of the element the next level up in the DOM
     */
    contents("contents"),
}

private val browserSupport = SupportData(
    chrome = 4.0,
    edge = 8.0,
    firefox = 3.0,
    safari = 3.1,
    opera = 7.0,
)

/**
 * The display property specifies the display behavior (the type of rendering box) of an element.
 */
public fun Rule.display(style: DisplayTypeValue) {
    +Property(
        property = "display",
        value = style.value,
        supportedBrowsers = browserSupport
    )
}

/**
 * The display property specifies the display behavior (the type of rendering box) of an element.
 */
public fun Rule.display(style: ModernDisplayTypeValues) {
    +Property(
        property = "display",
        value = style.value,
        supportedBrowsers = browserSupport + SupportDataOverride(
            edge = 79.0,
        )
    )
}

/**
 * The display property specifies the display behavior (the type of rendering box) of an element.
 */
public fun Rule.display(style: DisplayTypeValuesWithPrefix) {
    +Property(
        property = "display",
        value = style.value,
        supportedBrowsers = browserSupport + SupportDataOverride(
            safari = NOT_SUPPORTED,
        )
    ).webkit(SupportDataOverride(
        safari = 3.1,
    ))
}
