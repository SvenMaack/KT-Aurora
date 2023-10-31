package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Support
import css_lib.base.browser.SupportImpl

fun Rule.transform(x: Size, y: Size): Property {
    +object : Property("-webkit-transform", "translate($x,$y)"), Support by SupportImpl(
        chrome = { 36.0 },
        edge = { 10.0 },
        firefox = { 16.0 },
        safari = { 9.0 },
        opera = { 23.0 },
    ) {
        override val defaultValue: String?
            get() = null
    }
    return +object : Property("transform", "translate($x,$y)"), Support by SupportImpl(
        chrome = { 36.0 },
        edge = { 10.0 },
        firefox = { 16.0 },
        safari = { 9.0 },
        opera = { 23.0 },
    ) {
        override val defaultValue: String?
            get() = null
    }
}
