package css_lib.base

import css_lib.base.browser.Browser
import css_lib.base.browser.Support

abstract class Property(
    val property: String,
    val value: String
): Support {
    abstract val defaultValue: String?

    override fun toString(): String =
        "$property:$value;"
}

@Deprecated(message = "Use normal property")
class UnsupportedProperty(
    property: String,
    value: String
): Property(property, value) {
    override val defaultValue: String?
        get() = null
    override val support: List<Browser>
        get() = listOf()
}
