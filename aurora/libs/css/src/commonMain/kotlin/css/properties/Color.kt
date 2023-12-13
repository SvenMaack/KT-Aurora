@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_text_color.php

public interface ColorValue {
    public val value: String
}

public enum class ColorTextValue(public override val value: String): ColorValue {
    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),

    /**
     * 	Specifies that the background color should be transparent.
     */
    transparent("transparent"),

    /**
     * The currentcolor keyword refers to the value of the color property of an element.
     */
    currentcolor("currentcolor"),
}

@Deprecated("Use HSL(A)")
public data class HexValue(public override val value: String): ColorValue {
    public constructor(red: String, green: String, blue: String, alpha: String = ""): this(
        "#$red$green$blue$alpha"
    )
}
@Deprecated("Use HSL)")
public class RGBValue(red: String, green: String, blue: String): ColorValue {
    override val value: String =
        "rgb($red,$green,$blue)"
}
@Deprecated("Use HSLA")
public class RGBAValue(red: String, green: String, blue: String, alpha: String): ColorValue {
    override val value: String =
        "rgba($red,$green,$blue,$alpha)"
}
public class HSLValue(hue: Int, saturation: Int, lightness: Int): ColorValue {
    override val value: String =
        "hsl($hue,$saturation%,$lightness%)"
}
public class HSLAValue(hue: Int, saturation: Int, lightness: Int, alpha: Double): ColorValue {
    override val value: String =
        "hsla($hue,$saturation%,$lightness%,$alpha)"
}

/**
 * The color property specifies the color of text.
 */
public fun Rule.color(color: ColorValue) {
    +Property(
        property = "color",
        value = color.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 3.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 3.5,
        )
    )
}

/**
 * The color property specifies the color of text.
 */
public fun Rule.`background-color`(color: ColorValue) {
    +Property(
        property = "background-color",
        value = color.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 3.5,
        )
    )
}
