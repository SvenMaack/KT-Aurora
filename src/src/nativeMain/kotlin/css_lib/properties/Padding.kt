@file:Suppress("FunctionName")
package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

fun Rule.padding(value: Size): Rule =
    add(Property("padding", value.toString()))
fun Rule.`padding-top`(value: Size): Rule =
    add(Property("padding-top", value.toString()))
fun Rule.`padding-right`(value: Size): Rule =
    add(Property("padding-right", value.toString()))
fun Rule.`padding-bottom`(value: Size): Rule =
    add(Property("padding-bottom", value.toString()))
fun Rule.`padding-left`(value: Size): Rule =
    add(Property("padding-left", value.toString()))
