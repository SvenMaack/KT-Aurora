package basic

import css.base.Rule
import css.properties.HSLValue
import css.properties.color

public enum class COLOR{
    PRIMARY,
    PRIMARY_2,
    PRIMARY_3,
    TEXT,
    BACKGROUND,
    ACCENT
}

public fun Rule._color(color: COLOR) {
    when (color) {
        COLOR.PRIMARY -> {
            color(HSLValue(217, 64, 37))
        }
        COLOR.PRIMARY_2 -> {
            color(HSLValue(216, 20, 75))
        }
        COLOR.PRIMARY_3 -> {
            color(HSLValue(216, 20, 75))
        }
        COLOR.TEXT -> {
            color(HSLValue(0, 0, 0))
        }
        COLOR.BACKGROUND -> {
            color(HSLValue(255, 255, 255))
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
