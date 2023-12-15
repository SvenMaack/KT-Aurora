@file:Suppress("FunctionName", "TopLevelPropertyNaming", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.FontWeightTextValue.normal

//https://www.w3schools.com/cssref/pr_font_weight.php

public interface FontWeightValue {
    public val value: String
}

public enum class FontWeightTextValue(public override val value: String): FontWeightValue {
    /**
     * Defines normal characters. This is default
     */
    normal("normal"),

    /**
     * Defines thick characters
     */
    bold("bold"),

    /**
     * Defines thicker characters
     */
    bolder("bold"),

    /**
     * 	Defines lighter characters
     */
    lighter("bold"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `100`("100"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `200`("200"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `300`("300"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `400`("400"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `500`("500"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `600`("600"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `700`("700"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `800`("800"),

    /**
     * Defines from thin to thick characters. 400 is the same as normal, and 700 is the same as bold
     */
    `900`("900"),
}

/**
 * The font-weight property sets how thick or thin characters in text should be displayed.
 */
public inline var Rule.`font-weight`: FontWeightValue
    get() = normal
    set(weight) {
        +Property(
            property = "font-weight",
            value = weight.value,
            supportedBrowsers = SupportData(
                chrome = 2.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.3,
                opera = 3.5
            )
        )
    }
