package css.visitors

import css.base.Property
import css.base.PropertyVisitor
import kotlin.math.max

public class BrowserVersionVisitor: PropertyVisitor<Map<String, Double>>() {
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
