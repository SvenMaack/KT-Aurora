@file:Suppress("WrapUnaryOperator")
package basic

import css.base.Rule
import css.properties.`0`.unaryMinus
import css.properties.PositionTextValue.absolute
import css.properties.left
import css.properties.percentage
import css.properties.position
import css.properties.top
import css.properties.transform
import css.properties.translate

public inline fun Rule._center() {
    position = absolute
    transform = translate(-50.percentage, -50.percentage)
    top = 50.percentage
    left = 50.percentage
}
