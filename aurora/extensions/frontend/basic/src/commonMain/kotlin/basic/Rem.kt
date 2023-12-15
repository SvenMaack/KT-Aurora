package basic

import css.properties.ValueSize
import css.properties.rem

public inline fun _rem(pixel: Number): ValueSize =
    (pixel.toDouble() / 16.0).rem
