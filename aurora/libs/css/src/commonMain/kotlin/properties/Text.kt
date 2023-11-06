@file:Suppress("FunctionName", "unused")

package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.SupportImpl

@Suppress("EnumEntryName")
enum class TextTransformValues(val value: String) {
    none("none"),
    capitalize("capitalize"),
    uppercase("uppercase"),
    lowercase("lowercase"),
    initial("initial"),
    inherit("inherit"),
}

fun Rule.`text-transform`(style: TextTransformValues): Property =
    +Property.build(
        property = "text-transform",
        value = style.value,
        defaultValue = null,
        supportedBrowsers = SupportImpl(
            chrome = { 1.0 },
            edge = { 4.0 },
            firefox = { 1.0 },
            safari = { 1.0 },
            opera = { 7.0 },
        ).supportedBrowsers
    )
