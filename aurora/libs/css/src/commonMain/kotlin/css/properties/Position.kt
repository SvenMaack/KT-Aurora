@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.webkit
import css.properties.PositionTextValue.static
import css.properties.PositionTextValue.sticky

//https://www.w3schools.com/cssref/pr_class_position.php

public interface PositionValue {
    public val value: String
}

public enum class PositionTextValue(public override val value: String): PositionValue {
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

    /**
     * 	The element is positioned based on the user's scroll position
     * A sticky element toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed).
     */
    sticky("sticky")
}

public inline var Rule.position: PositionValue
    get() = static
    set(value) {
        if(value == sticky)
            +Property(
                property = "position",
                value = value.value,
                supportedBrowsers = SupportData(
                    chrome = 1.0,
                    edge = 16.0,
                    firefox = 1.0,
                    safari = 1.0,
                    opera = 4.0,
                )
            ).webkit(SupportDataOverride(
                safari = 6.1
            ))
        else
            +Property(
                property = "position",
                value = value.value,
                supportedBrowsers = SupportData(
                    chrome = 1.0,
                    edge = 7.0,
                    firefox = 1.0,
                    safari = 1.0,
                    opera = 4.0,
                )
            )

    }
