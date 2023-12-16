@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.TextDecorationThicknessTextValue.auto

//https://www.w3schools.com/cssref/pr_text_text-decoration-thickness.php

public interface TextDecorationThicknessValue {
    public val value: String
}

public enum class TextDecorationThicknessTextValue(public override val value: String): TextDecorationThicknessValue{
    /**
     *	The browser chooses the thickness of the decoration line
     */
    auto("auto"),

    /**
     * If a font file contains information about a preferred thickness, use that value. If not, behave as auto
     */
    `from-font`("from-font")
}

/**
 * The text-decoration-thickness property specifies the thickness of the decoration line.
 */
public inline var Rule.`text-decoration-thickness`: TextDecorationThicknessValue
    get() = auto
    set(thickness) {
        +Property(
            property = "text-decoration-thickness",
            value = thickness.value,
            supportedBrowsers = SupportData(
                chrome = 89.0,
                edge = 89.0,
                firefox = 70.0,
                safari = 12.1,
                opera = 75.0,
            )
        )
    }
