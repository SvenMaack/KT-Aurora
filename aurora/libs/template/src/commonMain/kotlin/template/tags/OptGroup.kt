package template.tags

import template.base.Attribute

/**
 * The optgroup-tag is used to group related options in a select-element (drop-down list).
 */
public class OptGroup: BodyTagContainer("optgroup") {
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
