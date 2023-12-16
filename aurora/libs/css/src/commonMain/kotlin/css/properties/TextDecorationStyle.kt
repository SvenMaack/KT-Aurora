@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.properties.TextDecorationStyleTextValue.solid

//https://www.w3schools.com/cssref/css3_pr_text-decoration-style.php

public interface TextDecorationStyleValue {
    public val value: String
}

public enum class TextDecorationStyleTextValue(public override val value: String): TextDecorationStyleValue{
    /**
     * Default value. The line will display as a single line
     */
    solid("solid"),

    /**
     * The line will display as a double line
     */
    double("double"),

    /**
     * The line will display as a dotted line
     */
    dotted("dotted"),

    /**
     * The line will display as a dashed line
     */
    dashed("dashed"),

    /**
     * The line will display as a wavy line
     */
    wavy("wavy"),
}

/**
 * The text-decoration-style property sets the style of the text decoration (like solid, wavy, dotted, dashed, double).
 */
public inline var Rule.`text-decoration-style`: TextDecorationStyleValue
    get() = solid
    set(style) {
        +Property(
            property = "text-decoration-style",
            value = style.value,
            supportedBrowsers = SupportData(
                chrome = 57.0,
                edge = 79.0,
                firefox = 36.0,
                safari = 12.1,
                opera = 44.0,
            )
        ).moz(SupportDataOverride(
            firefox = 6.0,
        ))
    }
