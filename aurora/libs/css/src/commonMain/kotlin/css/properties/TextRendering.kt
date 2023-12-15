@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.TextRenderingTextValue.auto

//https://www.w3schools.com/cssref/pr_text_text-transform.php

public interface TextRenderingValue {
    public val value: String
}

public enum class TextRenderingTextValue(public override val value: String): TextRenderingValue {
    auto("auto"),
    optimizeSpeed("optimizeSpeed"),
    optimizeLegibility("optimizeLegibility")
}

/**
 * The text-rendering CSS property provides information to the rendering engine about what to optimize for when rendering text.
 */
public inline var Rule.`text-rendering`: TextRenderingValue
    get() = auto
    set(rendering) {
        +Property(
            property = "text-rendering",
            value = rendering.value,
            supportedBrowsers = SupportData(
                chrome = 4.0,
                edge = 79.0,
                firefox = 1.0,
                safari = 5.0,
                opera = 15.0,
            )
        )
    }
