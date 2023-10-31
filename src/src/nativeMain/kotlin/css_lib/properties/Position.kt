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

fun Rule.top(position: Size): Rule =
    add(Property("top", position.toString()))

fun Rule.right(position: Size): Rule =
    add(Property("right", position.toString()))

fun Rule.bottom(position: Size): Rule =
    add(Property("bottom", position.toString()))

fun Rule.left(position: Size): Rule =
    add(Property("left", position.toString()))
