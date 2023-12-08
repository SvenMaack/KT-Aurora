@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.NOT_SUPPORTED
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.webkit

//https://www.w3schools.com/cssref/pr_class_position.php

private val supportDistance = SupportData(
    chrome = 1.0,
    edge = 5.5,
    firefox = 1.0,
    safari = 1.0,
    opera = 5.0,
)

@Suppress("EnumEntryName", "EnumNaming")
public enum class PositionValue(public val value: String) {
    /**
     * Default value. Elements render in order, as they appear in the document flow
     */
    static("static"),

    /**
     * The element is positioned relative to its first positioned (not static) ancestor element
     */
    absolute("absolute"),

    /**
     * The element is positioned relative to the browser window
     */
    fixed("fixed"),

    /**
     * The element is positioned relative to its normal position, so "left:20px" adds 20 pixels to the element's LEFT position
     */
    relative("relative"),

    initial("initial"),
    inherit("inherit"),
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class PositionValueWithPrefix(public val value: String) {
    /**
     * 	The element is positioned based on the user's scroll position
     * A sticky element toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed).
     */
    sticky("sticky")
}

public interface PositionDistanceValue{
    public val value: String
}

@Suppress("EnumEntryName", "EnumNaming")
public enum class PositionDistanceTextValue(public override val value: String): PositionDistanceValue {
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

public fun Rule.position(position: PositionValueWithPrefix) {
    +Property(
        property = "position",
        value = position.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 15.0,
            firefox = 1.0,
            safari = NOT_SUPPORTED,
            opera = 4.0,
        )
    ).webkit(SupportDataOverride(
        safari = 6.1
    ))
}

public fun Rule.top(value: PositionDistanceValue) {
    +Property(
        property = "top",
        value = value.value,
        supportedBrowsers = supportDistance
    )
}

public fun Rule.right(value: PositionDistanceValue) {
    +Property(
        property = "right",
        value = value.value,
        supportedBrowsers = supportDistance
    )
}
public fun Rule.bottom(value: PositionDistanceValue) {
    +Property(
        property = "bottom",
        value = value.value,
        supportedBrowsers = supportDistance
    )
}

public fun Rule.left(value: PositionDistanceValue) {
    +Property(
        property = "left",
        value = value.value,
        supportedBrowsers = supportDistance
    )
}
