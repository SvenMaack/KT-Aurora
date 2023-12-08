package css.base

import css.base.browser.Support
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride

public interface IProperty: Support {
    public val property: String
    public val value: String
}

public data class Property(
    override val property: String,
    override val value: String,
    override val supportedBrowsers: SupportData
): IProperty{
    override fun toString(): String =
        "$property:$value;"
}

private data class PrefixedProperty(
    val originalProperty: IProperty,
    val prefix: String,
    override val supportedBrowsers: SupportData
): IProperty {
    override val property: String =
        originalProperty.property
    override val value: String =
        originalProperty.value

    override fun toString(): String =
        "$prefix-${originalProperty.property}:${originalProperty.value};$originalProperty"
}

public fun IProperty.moz(supportExtension: SupportDataOverride): IProperty =
    PrefixedProperty(this, "-moz", this.supportedBrowsers + supportExtension)

public fun IProperty.webkit(supportExtension: SupportDataOverride): IProperty =
    PrefixedProperty(this, "-webkit", this.supportedBrowsers + supportExtension)
