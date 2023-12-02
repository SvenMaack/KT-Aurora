package template.tags

import template.base.Attribute
import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import template.base.get

public class OptGroup: BodyTagContainer("optgroup") {
    @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
    public inline fun option(
        vararg attributes: Attribute,
        clazz: String? = null,
        label: String,
        value: String,
        disabled: Boolean = false,
        selected: Boolean = false,
        init: Option.() -> Unit): Option = add(Option())
    {
        val otherAttributes = mutableListOf(
            "label"[label],
            "value"[value],
        )
        if (selected)
            otherAttributes.add(AttributeImpl(name = "selected"))
        if (disabled)
            otherAttributes.add(AttributeImpl(name = "disabled"))
        if (clazz != null)
            otherAttributes.add(AttributeWithValueImpl(name = "class", value = clazz))

        setAttributes(*attributes, *otherAttributes.toTypedArray())
        init()
    }
}
