@file:Suppress("FunctionName", "TopLevelPropertyNaming", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_font_font-variant.php

public interface FontVariantValue {
    public val value: String
}

public enum class FontVariantTextValue(public override val value: String): FontVariantValue {
    /**
     * The browser displays a normal font. This is default
     */
    normal("normal"),

    /**
     * The browser displays a small-caps font
     */
    `small-caps`("small-caps")
}

/**
 * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
 */
public inline var Rule.`font-variant`: FontVariantValue
    get() = FontVariantTextValue.normal
    set(variant) {
        +Property(
            property = "font-variant",
            value = variant.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5
            )
        )
    }
