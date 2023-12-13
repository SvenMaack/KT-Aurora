package basic

import css.base.Rule
import css.properties.HSLValue
import css.properties.color

public enum class COLOR{
    PRIMARY,
    PRIMARY_2,
    PRIMARY_3,
    PRIMARY_4,
    ACCENT
}

public fun Rule._color(color: COLOR) {
    when (color) {
        COLOR.PRIMARY -> {
            color(HSLValue(223, 46, 34)) //marian-blue
        }
        COLOR.PRIMARY_2 -> {
            color(HSLValue(223, 46, 34)) //alice-blue
        }
        COLOR.PRIMARY_3 -> {
            color(HSLValue(204, 100, 93)) //light-sky-blue
        }
        COLOR.PRIMARY_4 -> {
            color(HSLValue(203, 84, 74)) // light-sky-blue-2
        }
        COLOR.ACCENT -> {
            color(HSLValue(341, 100, 72)) //cyclamen
        }
    }
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
