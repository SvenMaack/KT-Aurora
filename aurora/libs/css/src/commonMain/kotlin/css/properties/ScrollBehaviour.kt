@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.ScrollBehaviourTextValue.auto

//https://www.w3schools.com/cssref/pr_scroll-behavior.php

public interface ScrollBehaviourValue {
    public val value: String
}

public enum class ScrollBehaviourTextValue(public override val value: String): ScrollBehaviourValue {
    /**
     * Allows a straight jump "scroll effect" between elements within the scrolling box. This is default.
     */
    auto("auto"),

    /**
     * Allows a smooth animated "scroll effect" between elements within the scrolling box.
     */
    smooth("smooth")
}

/**
 * The scroll-behavior property specifies whether to smoothly animate the scroll position, instead of a straight jump, when the user clicks on a link within a scrollable box.
 */
public inline var Rule.`scroll-behavior`: ScrollBehaviourValue
    get() = auto
    set(behaviour) {
        +Property(
            property = "scroll-behavior",
            value = behaviour.value,
            supportedBrowsers = SupportData(
                chrome = 61.0,
                edge = 79.0,
                firefox = 36.0,
                safari = 14.0,
                opera = 48.0,
            )
        )
    }
