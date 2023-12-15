@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-wrap.php

public interface FlexWrapValue {
    public val value: String
}

public enum class FlexWrapTextValue(public override val value: String): FlexWrapValue {
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
}

/**
 * The flex-wrap property specifies whether the flexible items should wrap or not.
 */
public inline var Rule.`flex-wrap`: FlexWrapValue
    get() = FlexWrapTextValue.nowrap
    set(wrap) {
        +Property(
            property = "flex-wrap",
            value = wrap.value,
            supportedBrowsers = SupportData(
                chrome = 29.0,
                edge = 11.0,
                firefox = 28.0,
                safari = 9.0,
                opera = 17.0,
            )
        ).webkit(SupportDataOverride(
            chrome = 21.0,
            safari = 6.1
        )).moz(SupportDataOverride(
            firefox = 18.0
        ))
    }
