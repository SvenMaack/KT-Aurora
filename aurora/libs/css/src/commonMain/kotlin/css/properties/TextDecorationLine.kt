@file:Suppress("TopLevelPropertyNaming", "UseIfInsteadOfWhen", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_text-decoration-line.php

public interface TextDecorationLineValue {
    public val value: String
}

public enum class TextDecorationLineTextValue(public override val value: String): TextDecorationLineValue{
    /**
     * Specifies that a line will be displayed under the text
     */
    underline("underline"),

    /**
     * Specifies that a line will be displayed over the text
     */
    overline("overline"),

    /**
     * Specifies that a line will be displayed through the text
     */
    line_through("line-through"),
}

/**
 * The text-decoration-line property sets the kind of text decoration to use (like underline, overline, line-through).
 */
public inline var Rule.`text-decoration-line`: TextDecorationLineValue
    get() = none
    set(line) {
        +Property(
            property = "text-decoration-line",
            value = line.value,
            supportedBrowsers = SupportData(
                chrome = 57.0,
                edge = 79.0,
                firefox = 36.0,
                safari = 12.1,
                opera = 44.0,
            )
        ).moz(SupportDataOverride(
            firefox = 6.0,
        )).webkit(SupportDataOverride(
            safari = 7.1,
        ))
    }
