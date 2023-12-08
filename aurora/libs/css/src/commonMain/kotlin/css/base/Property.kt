package css.base

import css.base.browser.Support
import css.base.browser.Browser

public data class Property(
    internal val property: String,
    internal val value: String,
    override val supportedBrowsers: List<Browser>
): Support {
    override fun toString(): String =
        "$property:$value;"
}
