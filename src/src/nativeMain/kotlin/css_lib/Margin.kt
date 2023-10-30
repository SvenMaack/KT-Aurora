package css_lib

fun Rule.margin(value: Size): Rule =
    add(Property("margin", value.toString()))
fun Rule.`margin-top`(value: Size): Rule =
    add(Property("margin-top", value.toString()))
fun Rule.`margin-right`(value: Size): Rule =
    add(Property("margin-right", value.toString()))
fun Rule.`margin-bottom`(value: Size): Rule =
    add(Property("margin-bottom", value.toString()))
fun Rule.`margin-left`(value: Size): Rule =
    add(Property("margin-left", value.toString()))
