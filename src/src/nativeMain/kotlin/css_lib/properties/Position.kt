package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

@Suppress("EnumEntryName")
enum class PositionValues(val value: String) {
    static("static"),
    relative("relative"),
    fixed("fixed"),
    absolute("absolute"),
    sticky("sticky")
}

fun Rule.position(position: PositionValues): Rule =
    add(Property("position", position.value))
