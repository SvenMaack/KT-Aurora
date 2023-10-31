@file:Suppress("FunctionName")

package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Support
import css_lib.base.browser.SupportImpl

@Suppress("EnumEntryName")
enum class TextDecorationValues(val value: String) {
    none("none"),
}

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
    +object : Property("text-transform", style.value), Support by SupportImpl(
        chrome = { 1.0 },
        edge = { 4.0 },
        firefox = { 1.0 },
        safari = { 1.0 },
        opera = { 7.0 },
    ) {
        override val defaultValue: String?
            get() = null
    }
