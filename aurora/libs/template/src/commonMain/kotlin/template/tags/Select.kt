package template.tags

import template.base.Attribute
import template.base.TemplatingApi
import template.base.get

/**
 * The select-element is used to create a drop-down list.
 */
@OptIn(TemplatingApi::class)
public class Select(public override val id: String): BodyTagContainer("select"), FormElement {
    /**
     * The optgroup-tag is used to group related options in a select-element (drop-down list).
     */
    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun optGroup(
        vararg attributes: Attribute,
        clazz: String? = null,
        label: String,
        disabled: Boolean = false,
        init: OptGroup.() -> Unit): OptGroup = add(OptGroup())
    {
        setAttributes(
            *attributes,
            "label"[label],
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
     * The option-tag defines an option in a select list.
     */
    @Suppress("LongParameterList", "LongMethod", "SpreadOperator")
    public inline fun option(
        vararg attributes: Attribute,
        clazz: String? = null,
        label: String,
        value: String,
        disabled: Boolean = false,
        selected: Boolean = false,
        init: Option.() -> Unit): Option = Option.addOptionTagWithAttributes(
            this,
                clazz,
                label,
                value,
                disabled,
                selected,
                *attributes,
            ).apply(init)
}
