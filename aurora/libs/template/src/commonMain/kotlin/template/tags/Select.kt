package template.tags

import template.base.Attribute
import template.base.AttributeImpl
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
}
