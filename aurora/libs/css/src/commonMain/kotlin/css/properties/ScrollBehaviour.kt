@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_scroll-behavior.php

public enum class ScrollBehaviour(public val value: String) {
    /**
     * Allows a straight jump "scroll effect" between elements within the scrolling box. This is default.
     */
    auto("auto"),

    /**
     * Allows a smooth animated "scroll effect" between elements within the scrolling box.
     */
    smooth("smooth"),

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
    chrome = 61.0,
    edge = 79.0,
    firefox = 36.0,
    safari = 14.0,
    opera = 48.0,
)

/**
 * The scroll-behavior property specifies whether to smoothly animate the scroll position, instead of a straight jump, when the user clicks on a link within a scrollable box.
 */
public fun Rule.`scroll-behavior`(behaviour: ScrollBehaviour) {
    +Property(
        property = "scroll-behavior",
        value = behaviour.value,
        supportedBrowsers = browserSupport
    )
}
