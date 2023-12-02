package template.tags

import template.base.Attribute
import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import template.base.get

public class Select(public override val id: String): BodyTagContainer("select"), FormElement {
    @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
    public inline fun optGroup(
        vararg attributes: Attribute,
        clazz: String? = null,
        label: String,
        disabled: Boolean = false,
        init: OptGroup.() -> Unit): OptGroup = add(OptGroup())
    {
        if(clazz==null && disabled)
            setAttributes(*attributes, "label"[label], AttributeImpl("disabled"))
        else if(clazz==null && !disabled)
                setAttributes(*attributes, "label"[label])
        else if(disabled)
            setAttributes(*attributes, "class"[clazz], "label"[label], AttributeImpl("disabled"))
        else
            setAttributes(*attributes, "class"[clazz], "label"[label])
        init()
    }

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
