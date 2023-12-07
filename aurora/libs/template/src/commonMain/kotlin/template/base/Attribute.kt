package template.base

public interface Attribute {
    public val name: String
    public val value: String?
}

@PublishedApi
internal data class AttributeImpl(
    override val name: String,
): Attribute {
    override val value: String? =
        null
}

@PublishedApi
internal data class AttributeWithValueImpl(
    override val name: String,
    override val value: String
): Attribute

public inline operator fun String.get(value: String?): Attribute =
    if(value == null)
        AttributeImpl(this)
    else
        AttributeWithValueImpl(this@get, value)

public inline operator fun String.get(vararg value: String?): Attribute {
    val notNull = value.filterNotNull()
    return if(notNull.isEmpty())
        AttributeImpl(this)
    else
        AttributeWithValueImpl(this, notNull.joinToString(" "))
}

public inline operator fun String.rem(condition: Boolean): String? =
    if(condition) this else null
