package css_lib.visitors

import css_lib.base.Property
import css_lib.base.PropertyVisitor
import kotlin.math.max

class BrowserVersionVisitor: PropertyVisitor<Map<String, Double>>() {
    override val result: MutableMap<String, Double> = mutableMapOf()

    override fun visitProperty(property: Property): BrowserVersionVisitor {
        property.supportedBrowsers.forEach { support ->
            result[support.browserName] = max(
                support.minimalSupportedVersion(),
                result.getOrElse(support.browserName) {0.0}
            )
        }
        return this
    }
}
