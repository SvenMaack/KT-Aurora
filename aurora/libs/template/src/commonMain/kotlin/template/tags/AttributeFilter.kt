package template.tags

import template.base.Attribute

public data class BoolAttribute(
    override val name: String,
    val use: Boolean,
): Attribute {
    override val value: String? =
        null
}

public object AttributeFilter {
    public inline fun filterNotNull(
        vararg attribute: Attribute
    ): Array<Attribute> =
        attribute.filter { it.value != null }.toTypedArray()

    public inline fun filterTrue(
        vararg attribute: BoolAttribute
    ): Array<Attribute> =
        attribute.filter { it.use }.toTypedArray()
}
