@file:Suppress("FunctionName")

package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

@Suppress("EnumEntryName")
enum class TextDecorationValues(val value: String) {
    none("none"),
}

@Suppress("EnumEntryName")
enum class TextTransformValues(val value: String) {
    uppercase("uppercase"),
}

fun Rule.`text-decoration`(style: TextDecorationValues): Rule =
    add(Property("text-decoration", style.value))

fun Rule.`text-transform`(style: TextTransformValues): Rule =
    add(Property("text-transform", style.value))
