package template_lib.base

public interface Attribute {
    public val name: String
    public val value: String?
}

@PublishedApi
internal class AttributeImpl(
    override val name: String,
): Attribute {
    override val value: String? =
        null
}

@PublishedApi
internal class AttributeWithValueImpl(
    override val name: String,
    override val value: String
): Attribute

public inline operator fun String.get(value: String?): Attribute =
    if(value == null)
        AttributeImpl(this@get)
    else
        AttributeWithValueImpl(this@get, value)
