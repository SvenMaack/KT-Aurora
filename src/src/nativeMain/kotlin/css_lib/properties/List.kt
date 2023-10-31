@file:Suppress("FunctionName")

package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

@Suppress("EnumEntryName")
enum class ListStyleValues(val value: String) {
    none("none"),
}

fun Rule.`list-style`(style: ListStyleValues): Rule =
    add(Property("list-style", style.value))
