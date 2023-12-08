package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public fun Rule.transform(x: Size, y: Size) {
    +Property(
        property = "-webkit-transform",
        value = "translate($x,$y)",
        supportedBrowsers = SupportData(
            chrome = 36.0,
            edge = 10.0,
            firefox = 16.0,
            safari = 9.0,
            opera = 23.0,
        )
    )
    +Property(
        property = "transform",
        value = "translate($x,$y)",
        supportedBrowsers = SupportData(
            chrome = 36.0,
            edge = 10.0,
            firefox = 16.0,
            safari = 9.0,
            opera = 23.0,
        )
    )
}
