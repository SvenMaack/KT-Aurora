@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit
import css.properties.BoxSizingTextValue.`padding-box`

//https://www.w3schools.com/cssref/css3_pr_box-sizing.php

public interface BoxSizingValue {
    public val value: String
}

public enum class BoxSizingTextValue(public override val value: String): BoxSizingValue {
    /**
     * 	Default. The width and height properties (and min/max properties) includes only the content. Border and padding are not included
     */
    `content-box`("content-box"),

    /**
     * 	The width and height properties (and min/max properties) includes content, padding and border
     */
    `border-box`("border-box"),

    /**
     * 	The width and height properties (and min/max properties) includes content and padding but no border.
     */
    `padding-box`("padding-box"),
}

/**
 * The box-sizing property defines how the width and height of an element are calculated: should they include padding and borders, or not.
 */
public inline var Rule.`box-sizing`: BoxSizingValue
    get() = BoxSizingTextValue.`content-box`
    set(sizing) {
        when(sizing) {
            `padding-box` ->
                +Property(
                    property = "box-sizing",
                    value = sizing.value,
                    supportedBrowsers = SupportData(firefox = 49.0)
                )
            else ->
                +Property(
                    property = "box-sizing",
                    value = sizing.value,
                    supportedBrowsers = SupportData(
                        chrome = 10.0,
                        edge = 8.0,
                        firefox = 29.0,
                        safari = 5.1,
                        opera = 9.5,
                    )
                ).moz(
                    SupportDataOverride(
                        firefox = 2.0,
                    )
                ).webkit(
                    SupportDataOverride(
                        chrome = 4.0,
                        safari = 3.2,
                    )
                )
        }
    }
