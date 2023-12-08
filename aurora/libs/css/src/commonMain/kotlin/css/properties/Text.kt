@file:Suppress("FunctionName")

package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportImpl

@Suppress("EnumEntryName", "EnumNaming")
public enum class TextTransformValues(public val value: String) {
    none("none"),
    capitalize("capitalize"),
    uppercase("uppercase"),
    lowercase("lowercase"),
    initial("initial"),
    inherit("inherit"),
}

public fun Rule.`text-transform`(style: TextTransformValues): Property =
    +Property(
        property = "text-transform",
        value = style.value,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )
