package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

@Suppress("EnumEntryName")
enum class DisplayTypeValues(val value: String) {
    `inline-block`("inline-block"),
}

fun Rule.display(style: DisplayTypeValues): Rule =
    add(Property("display", style.value))
