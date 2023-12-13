package basic

import css.base.Rule
import css.properties.HSLValue
import css.properties.`background-color`
import css.properties.color

public enum class COLOR(public val color: HSLValue) {
    PRIMARY(HSLValue(217, 64, 37)),
    PRIMARY_2(HSLValue(216, 20, 75)),
    PRIMARY_3(HSLValue(216, 20, 75)),
    TEXT(HSLValue(0, 0, 0)),
    BACKGROUND(HSLValue(255, 255, 255)),
    ACCENT(HSLValue(341, 100, 72)) //cyclamen
}

public fun Rule._color(color: COLOR) {
    color(color.color)
}

@Suppress("FunctionName")
public fun Rule.`_background-color`(color: COLOR) {
    `background-color`(color.color)
}

/**
$gradient-top: linear-gradient(0deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-right: linear-gradient(90deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-bottom: linear-gradient(180deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-left: linear-gradient(270deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-top-right: linear-gradient(45deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-bottom-right: linear-gradient(135deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-top-left: linear-gradient(225deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-bottom-left: linear-gradient(315deg, #2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
$gradient-radial: radial-gradient(#2f457eff, #d9f0ffff, #a3d5ffff, #83c9f4ff, #ff729fff);
 */
