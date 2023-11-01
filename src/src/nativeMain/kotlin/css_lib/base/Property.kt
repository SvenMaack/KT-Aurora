package css_lib.base

import css_lib.base.browser.Browser
import css_lib.base.browser.Support

abstract class Property(
    internal val property: String,
    internal val value: String
): Support {
    companion object {
        fun build(
            property: String,
            value: String,
            defaultValue: String? = "",
            support: List<Browser> = listOf()
        ): Property = object: Property(property, value) {
            override val defaultValue: String? = defaultValue
            override val supportedBrowsers: List<Browser> = support
        }
    }

    abstract val defaultValue: String?

    override fun toString(): String =
        "$property:$value;"
}
