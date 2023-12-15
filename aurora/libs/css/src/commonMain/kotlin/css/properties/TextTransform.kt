@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_text_text-transform.php

public interface TextTransformValue {
    public val value: String
}

public enum class TextTransformTextValue(public override val value: String): TextTransformValue {
    capitalize("capitalize"),
    uppercase("uppercase"),
    lowercase("lowercase"),
}

/**
 * The text-transform property controls the capitalization of text.
 */
public inline var Rule.`text-transform`: TextTransformValue
    get() = none
    set(transform) {
        +Property(
            property = "text-transform",
            value = transform.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 7.0,
            )
        )
    }
