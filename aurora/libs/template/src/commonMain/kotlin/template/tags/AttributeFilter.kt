package template.tags

import template.base.Attribute

@PublishedApi
internal data class BoolAttribute(
    override val name: String,
    val use: Boolean,
): Attribute {
    override val value: String? =
        null
}

@PublishedApi
internal object AttributeFilter {
    @PublishedApi
    internal inline fun filterNotNull(
        vararg attribute: Attribute
    ): Array<Attribute> =
        attribute.filter { it.value != null }.toTypedArray()

    @PublishedApi
    internal inline fun filterTrue(
        vararg attribute: BoolAttribute
    ): Array<Attribute> =
        attribute.filter { it.use }.toTypedArray()
}
