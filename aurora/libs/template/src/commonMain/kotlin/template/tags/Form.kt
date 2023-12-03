package template.tags

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import template.base.Attribute
import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import template.base.get
import template.tags.enums.EncType
import template.tags.enums.Method
import template.tags.enums.Target

@PublishedApi internal const val YEAR_PADDING: Int = 4
@PublishedApi internal const val MONTH_PADDING: Int = 2
@PublishedApi internal const val DAY_PADDING: Int = 2
@PublishedApi internal const val HOUR_PADDING: Int = 2
@PublishedApi internal const val MINUTE_PADDING: Int = 2
@PublishedApi internal const val SECOND_PADDING: Int = 2

/**
 * The form-tag is used to create an HTML form for user input.
 */
@Suppress("LargeClass", "LongParameterList", "TooManyFunctions")
public open class Form internal constructor(public val id: String, tagName: String): BodyTagContainer(tagName) {

     public constructor(id: String): this(id, "form")

     /**
      * The button-tag defines a clickable button.
      */
     @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
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
      * The fieldset-tag is used to group related elements in a form. It draws a box around the related elements.
      */
     @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
     public inline fun fieldSet(
         vararg attributes: Attribute,
         clazz: String? = null,
         disabled: Boolean,
         name: String,
         init: Fieldset.() -> Unit): Fieldset = add(Fieldset(id))
     {
         setAttributes(
             *attributes,
             "name"[name],
             "form"[this@Form.id],
             *AttributeFilter.filterTrue(
                 BoolAttribute("disabled", disabled),
             ),
             *AttributeFilter.filterNotNull(
                 "class"[clazz],
             )
         )
         init()
     }

    /**
     * The label-tag defines a label for several form elements:
     */
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
        formEnctype: EncType = EncType.APPLICATION_X_WWW_FORM_URLENCODED,
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

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputFile(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        accept: Accept,
        autoFocus: Boolean = false,
        disabled: Boolean = false,
        required: Boolean = false,
        multiple: Boolean = false,
        defaultValue: String? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["file"],
            "accept"[accept.value],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("required", required),
                BoolAttribute("multiple", multiple),
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputCheckbox(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoFocus: Boolean = false,
        disabled: Boolean = false,
        required: Boolean = false,
        defaultValue: String? = null,
        defaultChecked: String? = null,
        indeterminate: Boolean? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["checkbox"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("required", required),
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "defaultChecked"[defaultChecked],
                "indeterminate"[indeterminate?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputColor(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        disabled: Boolean = false,
        defaultValue: String? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["color"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator", "CognitiveComplexMethod")
    public inline fun inputDate(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: LocalDate,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        readOnly: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        required: Boolean = false,
        max: LocalDate? = null,
        min: LocalDate? = null,
        step: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["date"],
            "value"["${value.year.toString().padStart(YEAR_PADDING, '0')}-${value.monthNumber.toString().padStart(MONTH_PADDING, '0')}-${value.dayOfMonth.toString().padStart(DAY_PADDING, '0')}"],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "max"[max?.let { "${max.year.toString().padStart(YEAR_PADDING, '0')}-${max.monthNumber.toString().padStart(MONTH_PADDING, '0')}-${max.dayOfMonth.toString().padStart(DAY_PADDING, '0')}" }],
                "min"[min?.let { "${min.year.toString().padStart(YEAR_PADDING, '0')}-${min.monthNumber.toString().padStart(MONTH_PADDING, '0')}-${min.dayOfMonth.toString().padStart(DAY_PADDING, '0')}" }],
                "step"[step?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputEmail(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        defaultValue: String? = null,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        disabled: Boolean = false,
        maxLength: Int? = null,
        multiple: Boolean = false,
        required: Boolean = false,
        readOnly: Boolean = false,
        pattern: String? = null,
        placeHolder: String? = null,
        size: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["email"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
                BoolAttribute("multiple", multiple),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "maxLength"[maxLength?.toString()],
                "pattern"[pattern],
                "placeholder"[placeHolder],
                "size"[size?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputHidden(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        defaultValue: String = value,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["hidden"],
            "value"[value],
            "defaultValue"[defaultValue],
            *AttributeFilter.filterNotNull(
                "class"[clazz],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator", "CognitiveComplexMethod")
    public inline fun inputMonth(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: LocalDate,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        max: LocalDate? = null,
        min: LocalDate? = null,
        required: Boolean = false,
        readOnly: Boolean = false,
        step: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["month"],
            "value"["${value.year.toString().padStart(YEAR_PADDING, '0')}-${value.monthNumber.toString().padStart(MONTH_PADDING, '0')}"],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "step"[step?.toString()],
                "max"[max?.let { "${max.year.toString().padStart(YEAR_PADDING, '0')}-${max.monthNumber.toString().padStart(MONTH_PADDING, '0')}" }],
                "min"[min?.let { "${min.year.toString().padStart(YEAR_PADDING, '0')}-${min.monthNumber.toString().padStart(MONTH_PADDING, '0')}" }],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputNumber(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: Int,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        max: Int? = null,
        min: Int? = null,
        required: Boolean = false,
        readOnly: Boolean = false,
        placeHolder: String? = null,
        step: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["number"],
            "value"[value.toString()],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "placeholder"[placeHolder],
                "step"[step?.toString()],
                "max"[max?.toString()],
                "min"[min?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputPassword(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        maxLength: Int? = null,
        required: Boolean = false,
        readOnly: Boolean = false,
        placeHolder: String? = null,
        pattern: String? = null,
        size: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["password"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "placeholder"[placeHolder],
                "pattern"[pattern],
                "size"[size?.toString()],
                "maxLength"[maxLength?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputRange(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: Int,
        max: Int,
        min: Int,
        step: Int,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["range"],
            "value"[value.toString()],
            "max"[max.toString()],
            "min"[min.toString()],
            "step"[step.toString()],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputRadio(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoFocus: Boolean = false,
        checked: Boolean = false,
        defaultChecked: String? = null,
        defaultValue: String? = null,
        required: Boolean = false,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["radio"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("checked", checked),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "defaultChecked"[defaultChecked],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputReset(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["reset"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputSearch(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        maxLength: Int? = null,
        pattern: String? = null,
        placeHolder: String? = null,
        readOnly: Boolean = false,
        required: Boolean = false,
        size: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["search"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "maxLength"[maxLength?.toString()],
                "pattern"[pattern],
                "placeholder"[placeHolder],
                "size"[size?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputText(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        maxLength: Int? = null,
        pattern: String? = null,
        placeHolder: String? = null,
        readOnly: Boolean = false,
        required: Boolean = false,
        size: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["text"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "maxLength"[maxLength?.toString()],
                "pattern"[pattern],
                "placeholder"[placeHolder],
                "size"[size?.toString()],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator", "CognitiveComplexMethod")
    public inline fun inputTime(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: LocalDateTime,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        max: LocalDateTime? = null,
        min: LocalDateTime? = null,
        readOnly: Boolean = false,
        required: Boolean = false,
        step: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["time"],
            "value"["${value.hour.toString().padStart(HOUR_PADDING, '0')}:${value.minute.toString().padStart(MINUTE_PADDING, '0')}:${value.second.toString().padStart(SECOND_PADDING, '0')}"],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "step"[step?.toString()],
                "max"[max?.let { "${max.hour.toString().padStart(HOUR_PADDING, '0')}:${max.minute.toString().padStart(MINUTE_PADDING, '0')}:${max.second.toString().padStart(SECOND_PADDING, '0')}" }],
                "min"[min?.let { "${min.hour.toString().padStart(HOUR_PADDING, '0')}:${min.minute.toString().padStart(MINUTE_PADDING, '0')}:${min.second.toString().padStart(SECOND_PADDING, '0')}" }],
            )
        )
        init()
    }

    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun inputUrl(
        vararg attributes: Attribute,
        clazz: String? = null,
        name: String,
        value: String,
        autoComplete: String? = null,
        autoFocus: Boolean = false,
        defaultValue: String? = null,
        disabled: Boolean = false,
        maxLength: Int? = null,
        pattern: String? = null,
        placeHolder: String? = null,
        readOnly: Boolean = false,
        required: Boolean = false,
        size: Int? = null,
        init: Input.() -> Unit): Input = add(Input())
    {
        setAttributes(
            *attributes,
            "name"[name],
            "form"[this@Form.id],
            "type"["url"],
            "value"[value],
            *AttributeFilter.filterTrue(
                BoolAttribute("autofocus", autoFocus),
                BoolAttribute("disabled", disabled),
                BoolAttribute("readOnly", readOnly),
                BoolAttribute("required", required),
            ),
            *AttributeFilter.filterNotNull(
                "class"[clazz],
                "defaultValue"[defaultValue],
                "autocomplete"[autoComplete],
                "pattern"[pattern],
                "placeholder"[placeHolder],
                "maxLength"[maxLength?.toString()],
                "size"[size?.toString()],
            )
        )
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
}
