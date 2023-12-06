package template.tags

import template.base.Attribute
import template.base.TagContainer
import template.base.TemplatingApi
import template.base.get

/**
 * The option-tag defines an option in a select list.
 */
@OptIn(TemplatingApi::class)
public class Option: TextContainer("option") {
    @PublishedApi
    internal companion object {
        @Suppress("LongParameterList", "SpreadOperator", "LongMethod")
        inline fun <T: TagContainer> addOptionTagWithAttributes(
            parent: T,
            clazz: String? = null,
            label: String,
            value: String,
            disabled: Boolean = false,
            selected: Boolean = false,
            vararg attributes: Attribute): Option = parent.add(Option())
        {
            setAttributes(
                *attributes,
                "label"[label],
                "value"[value],
                *AttributeFilter.filterTrue(
                    BoolAttribute("disabled", disabled),
                    BoolAttribute("selected", selected),
                ),
                *AttributeFilter.filterNotNull(
                    "class"[clazz],
                )
            )
        }
    }
}

