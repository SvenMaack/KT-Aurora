@file:Suppress("FunctionName")
package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

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
