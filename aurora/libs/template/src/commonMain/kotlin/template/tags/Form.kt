package template.tags

import template.base.Attribute
import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import template.base.get
import template.tags.enums.AutoComplete
import template.tags.enums.EncType
import template.tags.enums.Method
import template.tags.enums.Target

 @Suppress("LargeClass", "LongParameterList", "TooManyFunctions")
public open class Form(public val id: String, tagName: String = "form"): BodyTagContainer(tagName) {
     /**
      * The button-tag defines a clickable button.
      */
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
         setAttributes(
             *attributes,
             "name"[name],
             "form"[this@Form.id],
             "type"[type.value],
             *AttributeFilter.filterTrue(
                 BoolAttribute("autofocus", autoFocus),
                 BoolAttribute("disabled", disabled),
             ),
             *AttributeFilter.filterNotNull(
                 "class"[clazz],
                 "value"[value],
             )
         )
         init()
     }

     /**
      * The button-tag with type submit defines a clickable button for submitting a form.
      */
     @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
     public inline fun submit(
         vararg attributes: Attribute,
         name: String,
         formAction: String,
         clazz: String? = null,
         autoFocus: Boolean = false,
         disabled: Boolean = false,
         formEnctype: EncType = EncType.Application_x_www_form_urlencoded,
         formMethod: Method = Method.POST,
         formNoValidate: Boolean = false,
         formTarget: Target = Target.SELF,
         value: String? = null,
         init: Button.() -> Unit): Button = add(Button())
     {
         setAttributes(
             *attributes,
             "name"[name],
             "form"[this@Form.id],
             "type"["submit"],
             "formenctype"[formEnctype.value],
             "formmethod"[formMethod.value],
             "formtarget"[formTarget.value],
             "formaction"[formAction],
             *AttributeFilter.filterTrue(
                 BoolAttribute("formnovalidate", formNoValidate),
                 BoolAttribute("autofocus", autoFocus),
                 BoolAttribute("disabled", disabled),
             ),
             *AttributeFilter.filterNotNull(
                 "class"[clazz],
                 "value"[value],
             )
         )
         init()
     }


     public inline fun input(
         vararg attributes: Attribute,
         clazz: String? = null,
         name: String,
         type: InputType,
         value: String,
         init: Input.() -> Unit): Input = add(Input())
     {
         if(clazz==null)
             setAttributes(*attributes, "form"[this@Form.id], "name"[name], "type"[type.value], "value"[value])
         else
             setAttributes(*attributes, "class"[clazz], "form"[this@Form.id], "name"[name], "type"[type.value], "value"[value])
         init()
     }

     @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
     public inline fun input(
         vararg attributes: Attribute,
         clazz: String? = null,
         name: String,
         type: InputType,
         value: String,
         autocomplete: AutoComplete = AutoComplete.ON,
         autoFocus: Boolean = false,
         disabled: Boolean = false,
         checked: Boolean = false,
         dirName: Boolean = false,
         formEnctype: EncType = EncType.Application_x_www_form_urlencoded,
         formNoValidate: Boolean = false,
         max: Int = 0,
         maxLength: Int = 0,
         min: Int = 0,
         minLength: Int = 0,
         multiple: Boolean = false,
         pattern: String? = null,
         placeHolder: String? = null,
         readOnly: Boolean = false,
         required: Boolean = false,
         size: Int = 0,
         step: Int = 0,
         init: Input.() -> Unit): Input = add(Input())
     {
         val otherAttributes = mutableListOf(
             "form"[this@Form.id],
             "name"[name],
             "type"[type.value],
             "value"[value],
             "autocomplete"[autocomplete.value],
             "formenctype"[formEnctype.value],
             "max"[max.toString()],
             "maxlength"[maxLength.toString()],
             "min"[min.toString()],
             "minlength"[minLength.toString()],
             "size"[size.toString()],
             "step"[step.toString()],
         )
         if (placeHolder != null)
             otherAttributes.add(AttributeWithValueImpl("placeholder", placeHolder))
         if (pattern != null)
             otherAttributes.add(AttributeWithValueImpl("pattern", pattern))
         if (formNoValidate)
             otherAttributes.add(AttributeImpl(name = "formnovalidate"))
         if (checked)
             otherAttributes.add(AttributeImpl(name = "checked"))
         if (readOnly)
             otherAttributes.add(AttributeImpl(name = "readonly"))
         if (dirName)
             otherAttributes.add(AttributeWithValueImpl("dirname", "$name.dir"))
         if (required)
             otherAttributes.add(AttributeImpl(name = "required"))
         if (multiple)
             otherAttributes.add(AttributeImpl(name = "multiple"))
         if (autoFocus)
             otherAttributes.add(AttributeImpl(name = "autofocus"))
         if (disabled)
             otherAttributes.add(AttributeImpl(name = "disabled"))
         if (clazz != null)
             otherAttributes.add(AttributeWithValueImpl(name = "class", value = clazz))

         setAttributes(*attributes, *otherAttributes.toTypedArray())
         init()
     }

     @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
     public inline fun fieldSet(
         vararg attributes: Attribute,
         clazz: String? = null,
         disabled: Boolean,
         name: String,
         init: Fieldset.() -> Unit): Fieldset = add(Fieldset(id))
     {
         if(clazz==null && disabled)
             setAttributes(*attributes, "form"[this@Form.id], AttributeImpl("disabled"), "name"[name])
         else if(!disabled)
             setAttributes(*attributes, "form"[this@Form.id], "name"[name])
         else if(clazz != null && disabled)
             setAttributes(*attributes, "class"[clazz], "form"[this@Form.id], AttributeImpl("disabled"), "name"[name])
         else
             setAttributes(*attributes, "class"[clazz], "form"[this@Form.id], "name"[name])
         init()
     }

     public inline fun select(
         vararg attributes: Attribute,
         clazz: String? = null,
         id: String,
         name: String,
         init: Select.() -> Unit): Select = add(Select(id))
     {
         @Suppress("DuplicatedCode")
         if(clazz==null)
             setAttributes(*attributes, "form"[this@Form.id], "id"[id], "name"[name])
         else
             setAttributes(*attributes, "class"[clazz],"form"[this@Form.id], "id"[id], "name"[name])
         init()
     }

     @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
     public inline fun select(
         vararg attributes: Attribute,
         clazz: String? = null,
         id: String,
         autoFocus: Boolean = false,
         disabled: Boolean = false,
         multiple: Boolean = false,
         required: Boolean,
         name: String,
         size: Int = 4,
         init: Select.() -> Unit): Select = add(Select(id))
     {
         val otherAttributes = mutableListOf(
             "form"[this@Form.id],
             "id"[id],
             "name"[name],
             "size"[size.toString()],
         )
         if (required)
             otherAttributes.add(AttributeImpl(name = "required"))
         if (autoFocus)
             otherAttributes.add(AttributeImpl(name = "autofocus"))
         if (multiple)
             otherAttributes.add(AttributeImpl(name = "multiple"))
         if (disabled)
             otherAttributes.add(AttributeImpl(name = "disabled"))
         if (clazz != null)
             otherAttributes.add(AttributeWithValueImpl(name = "class", value = clazz))

         setAttributes(*attributes, *otherAttributes.toTypedArray())
         init()
     }

     public inline fun textArea(
         vararg attributes: Attribute,
         clazz: String? = null,
         id: String,
         name: String,
         init: TextArea.() -> Unit): TextArea = add(TextArea(id))
     {
         @Suppress("DuplicatedCode")
         if(clazz==null)
             setAttributes(*attributes, "form"[this@Form.id], "id"[id], "name"[name])
         else
             setAttributes(*attributes, "class"[clazz],"form"[this@Form.id], "id"[id], "name"[name])
         init()
     }

     @Suppress("LongParameterList", "CognitiveComplexMethod", "CyclomaticComplexMethod", "LongMethod", "SpreadOperator")
     public inline fun textArea(
         vararg attributes: Attribute,
         clazz: String? = null,
         id: String,
         autoFocus: Boolean = false,
         cols: Int = 20,
         rows: Int = 2,
         dirName: Boolean = false,
         disabled: Boolean = false,
         wrap: Wrap = Wrap.Soft,
         maxLength: Int,
         name: String,
         placeHolder: String? = null,
         readOnly: Boolean = false,
         required: Boolean = false,
         init: TextArea.() -> Unit): TextArea = add(TextArea(id))
     {
         val otherAttributes = mutableListOf(
             "form"[this@Form.id],
             "id"[id],
             "name"[name],
             "cols"[cols.toString()],
             "rows"[rows.toString()],
             "wrap"[wrap.value],
             "maxlength"[maxLength.toString()],
         )
         if (readOnly)
             otherAttributes.add(AttributeImpl(name = "readonly"))
         if (required)
             otherAttributes.add(AttributeImpl(name = "required"))
         if (autoFocus)
             otherAttributes.add(AttributeImpl(name = "autofocus"))
         if (disabled)
             otherAttributes.add(AttributeImpl(name = "disabled"))
         if (dirName)
             otherAttributes.add(AttributeWithValueImpl(name = "dirname", value = "$name.dir"))
         if (clazz != null)
             otherAttributes.add(AttributeWithValueImpl(name = "class", value = clazz))
         if (placeHolder != null)
             otherAttributes.add(AttributeWithValueImpl(name = "placeholder", value = placeHolder))

         setAttributes(*attributes, *otherAttributes.toTypedArray())
         init()
     }

    @Suppress("Naming", "FunctionParameterNaming")
    public inline fun label(
        vararg attributes: Attribute,
        clazz: String? = null,
        `for`: FormElement,
        init: Label.() -> Unit): Label = add(Label())
    {
        if(clazz==null)
            setAttributes(*attributes, "form"[this@Form.id], "for"[`for`.id])
        else
            setAttributes(*attributes, "class"[clazz],"form"[this@Form.id], "for"[`for`.id])
        init()
    }
}
