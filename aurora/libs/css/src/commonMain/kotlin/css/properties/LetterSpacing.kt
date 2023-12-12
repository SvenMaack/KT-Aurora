@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_text_letter-spacing.php

public interface LetterSpacingValue {
    public val value: String
}

public enum class LetterSpacingTextValue(public override val value: String): LetterSpacingValue {
    /**
     * Defines normal space between characters. This is default
     */
    normal("normal"),

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
    chrome = 1.0,
    edge = 4.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 3.5,
)


/**
 * The letter-spacing property increases or decreases the space between characters in a text.
 */
public fun Rule.`letter-spacing`(spacing: LetterSpacingValue) {
    +Property(
        property = "letter-spacing",
        value = spacing.value,
        supportedBrowsers = browserSupport
    )
}
