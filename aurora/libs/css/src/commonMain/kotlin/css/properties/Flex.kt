@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-basis.php

public enum class FlexValue(public val value: String) {
    /**
     * Same as 1 1 auto.
     */
    auto("auto"),

    /**
     * Same as 0 1 auto
     */
    initial("initial"),

    /**
     * Same as 0 0 auto.
     */
    none("none"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

public enum class FlexBasisValue(public val value: String) {
    /**
     * 	Default value. The length is equal to the length of the flexible item. If the item has no length specified, the length will be according to its content
     */
    auto("auto"),

    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

public enum class FlexDirectionValue(public val value: String) {
    /**
     * Default value. The flexible items are displayed horizontally, as a row.
     */
    row("row"),

    /**
     * Same as row, but in reverse order.
     */
    `row-reverse`("row-reverse"),

    /**
     * The flexible items are displayed vertically, as a column
     */
    column("column"),

    /**
     * Same as column, but in reverse order
     */
    `column-reverse`("column-reverse"),

    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

public enum class FlexSizeValue(public val value: String) {
    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

public enum class FlexWrapValue(public val value: String) {
    /**
     * Default value. Specifies that the flexible items will not wrap
     */
    nowrap("nowrap"),

    /**
     * Specifies that the flexible items will wrap if necessary
     */
    wrap("wrap"),

    /**
     * Specifies that the flexible items will wrap, if necessary, in reverse order
     */
    `wrap-reverse`("wrap-reverse"),

    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

private val browserSupport = SupportData(
    chrome = 29.0,
    edge = 11.0,
    firefox = 28.0,
    safari = 9.0,
    opera = 17.0,
)

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexSizeValue, shrink: FlexSizeValue, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "${grow.value} ${shrink.value} ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexSizeValue, shrink: FlexSizeValue, basis: Double) {
    +Property(
        property = "flex",
        value = "${grow.value} ${shrink.value} $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexSizeValue, shrink: Double, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "${grow.value} $shrink ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: FlexSizeValue, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "$grow ${shrink.value} ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: Double, basis: FlexBasisValue) {
    +Property(
        property = "flex",
        value = "$grow $shrink ${basis.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: FlexSizeValue, shrink: Double, basis: Double) {
    +Property(
        property = "flex",
        value = "${grow.value} $shrink $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: FlexSizeValue, basis: Double) {
    +Property(
        property = "flex",
        value = "$grow ${shrink.value} $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(grow: Double, shrink: Double, basis: Double) {
    +Property(
        property = "flex",
        value = "$grow $shrink $basis",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex property is a shorthand property
 */
public fun Rule.flex(basis: FlexValue) {
    +Property(
        property = "flex",
        value = basis.value,
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-basis property specifies the initial length of a flexible item.
 */
public fun Rule.`flex-basis`(basis: FlexBasisValue) {
    +Property(
        property = "flex-basis",
        value = basis.value,
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-basis property specifies the initial length of a flexible item.
 */
public fun Rule.`flex-basis`(basis: Double) {
    +Property(
        property = "flex-basis",
        value = basis.toString(),
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-direction property specifies the direction of the flexible items.
 */
public fun Rule.`flex-direction`(direction: FlexDirectionValue) {
    +Property(
        property = "flex-direction",
        value = direction.value,
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-grow property specifies how much the item will grow relative to the rest of the flexible items inside the same container.
 */
public fun Rule.`flex-grow`(grow: FlexSizeValue) {
    +Property(
        property = "flex-grow",
        value = grow.value,
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-grow property specifies how much the item will grow relative to the rest of the flexible items inside the same container.
 */
public fun Rule.`flex-grow`(grow: Double) {
    +Property(
        property = "flex-grow",
        value = grow.toString(),
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-shrink property specifies how much the item will shrink relative to the rest of the flexible items inside the same container.
 */
public fun Rule.`flex-shrink`(shrink: FlexSizeValue) {
    +Property(
        property = "flex-shrink",
        value = shrink.value,
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-shrink property specifies how much the item will shrink relative to the rest of the flexible items inside the same container.
 */
public fun Rule.`flex-shrink`(shrink: Double) {
    +Property(
        property = "flex-shrink",
        value = shrink.toString(),
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-wrap property specifies whether the flexible items should wrap or not.
 */
public fun Rule.`flex-wrap`(wrap: FlexWrapValue) {
    +Property(
        property = "flex-wrap",
        value = wrap.toString(),
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}

/**
 * The flex-flow property is a shorthand property.
 */
public fun Rule.`flex-flow`(direction: FlexDirectionValue, wrap: FlexWrapValue) {
    +Property(
        property = "flex-flow",
        value = "${direction.value} ${wrap.value}",
        supportedBrowsers = browserSupport
    ).webkit(SupportDataOverride(
        chrome = 21.0,
        safari = 6.1
    )).moz(SupportDataOverride(
        firefox = 18.0
    ))
}
