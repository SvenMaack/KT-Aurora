package template.tags

import template.base.Attribute
import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import template.base.get
import template.tags.enums.EncType
import template.tags.enums.Method
import template.tags.enums.Target

public enum class AutoComplete(public val value: String) {
    ON("on"),
    OFF("off")
}

public class Form(public val id: String): BodyTagContainer("form") {
    @Suppress("LongParameterList")
    public inline fun button(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        type: ButtonType = ButtonType.Button,
        init: Button.() -> Unit): Button = add(Button())
    {
        if(clazz==null)
            setAttributes(*attributes, "form"[this@Form.id], "name"[name], "type"[type.value])
        else
            setAttributes(*attributes, "class"[clazz], "form"[this@Form.id], "name"[name], "type"[type.value])
        init()
    }

    @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
    public inline fun button(
        vararg attributes: Attribute,
        clazz: String? = null,
        autoFocus: Boolean = false,
        disabled: Boolean = false,
        name: String,
        value: String? = null,
        type: ButtonType = ButtonType.Button,
        init: Button.() -> Unit): Button = add(Button())
    {
        val otherAttributes = mutableListOf(
            "form"[this@Form.id],
            "name"[name],
            "type"[type.value]
        )
        if (autoFocus)
            otherAttributes.add(AttributeImpl(name = "autofocus"))
        if (disabled)
            otherAttributes.add(AttributeImpl(name = "disabled"))
        if (value != null)
            otherAttributes.add(AttributeWithValueImpl(name = "value", value = value))
        if (clazz != null)
            otherAttributes.add(AttributeWithValueImpl(name = "class", value = clazz))

        setAttributes(*attributes, *otherAttributes.toTypedArray())
        init()
    }

    @Suppress("LongParameterList")
    public inline fun submit(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        init: Button.() -> Unit): Button = add(Button())
    {
        if(clazz==null)
            setAttributes(*attributes, "form"[this@Form.id], "name"[name], "type"["submit"])
        else
            setAttributes(*attributes, "class"[clazz], "form"[this@Form.id], "name"[name], "type"["submit"])
        init()
    }

    @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
    public inline fun submit(
        vararg attributes: Attribute,
        clazz: String? = null,
        autoFocus: Boolean = false,
        disabled: Boolean = false,
        formAction: String,
        formEnctype: EncType,
        formMethod: Method,
        formNoValidate: Boolean = false,
        formTarget: Target,
        name: String,
        value: String? = null,
        init: Button.() -> Unit): Button = add(Button())
    {
        val otherAttributes = mutableListOf(
            "form"[this@Form.id],
            "name"[name],
            "formaction"[formAction],
            "formenctype"[formEnctype.value],
            "formmethod"[formMethod.value],
            "type"["submit"],
            "formtarget"[formTarget.value]
        )
        if (autoFocus)
            otherAttributes.add(AttributeImpl(name = "autofocus"))
        if (disabled)
            otherAttributes.add(AttributeImpl(name = "disabled"))
        if (value != null)
            otherAttributes.add(AttributeWithValueImpl(name = "value", value = value))
        if (formNoValidate)
            otherAttributes.add(AttributeImpl(name = "formnovalidate"))
        if (clazz != null)
            otherAttributes.add(AttributeWithValueImpl(name = "class", value = clazz))

        setAttributes(*attributes, *otherAttributes.toTypedArray())
        init()
    }
}
