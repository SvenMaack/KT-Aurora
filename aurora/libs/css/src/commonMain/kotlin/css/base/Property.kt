package css.base

import css.base.browser.Support
import css.base.browser.Browser

public abstract class Property(
    internal val property: String,
    internal val value: String
): Support {
    public abstract val defaultValue: String?

    override fun toString(): String =
        "$property:$value;"

    public companion object {
        public fun build(
            property: String,
            value: String,
            defaultValue: String? = "",
            supportedBrowsers: List<Browser> = listOf()
        ): Property = object: Property(property, value) {
            override val defaultValue: String? = defaultValue
            override val supportedBrowsers: List<Browser> = supportedBrowsers
        }
    }
}
