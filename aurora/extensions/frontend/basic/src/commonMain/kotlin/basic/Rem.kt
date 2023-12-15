package basic

import css.properties.Size
import css.properties.rem

public inline fun <reified T: Size>_rem(pixel: Number): T =
    (pixel.toDouble() / 16.0).rem as T
