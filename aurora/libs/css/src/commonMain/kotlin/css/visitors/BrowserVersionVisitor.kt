package css.visitors

import css.base.IProperty
import css.base.PropertyVisitor
import kotlin.math.max

public class BrowserVersionVisitor: PropertyVisitor<Map<String, Double>>() {
    private var chrome: Double = 0.0
    private var firefox: Double = 0.0
    private var edge: Double = 0.0
    private var safari: Double = 0.0
    private var opera: Double = 0.0
    override val result: MutableMap<String, Double>
        get() = mutableMapOf(
            "chrome" to chrome,
            "firefox" to firefox,
            "edge" to edge,
            "safari" to safari,
            "opera" to opera
        )

    override fun visitProperty(property: IProperty): BrowserVersionVisitor {
        chrome = max(property.supportedBrowsers.chrome, chrome)
        firefox = max(property.supportedBrowsers.firefox, firefox)
        edge = max(property.supportedBrowsers.edge, edge)
        safari = max(property.supportedBrowsers.safari, safari)
        opera = max(property.supportedBrowsers.opera, opera)
        return this
    }
}
