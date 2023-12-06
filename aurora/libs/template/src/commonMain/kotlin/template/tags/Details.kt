package template.tags

import template.base.Attribute
import template.base.TagContainer
import template.base.TemplatingApi
import template.base.get

/**
 * The details-tag specifies additional details that the user can view or hide on demand. The details-tag is often used to create an interactive widget that the user can open and close. By default, the widget is closed. When open, it expands, and displays the content within.
 */
@OptIn(TemplatingApi::class)
public class Details: TagContainer("details") {
    /**
     * The summary-tag defines a visible heading for the details-element. The heading can be clicked to view/hide the details.
     */
    public inline fun summary(vararg attributes: Attribute, clazz: String? = null, init: Summary.() -> Unit): Summary = add(Summary()) {
        if(clazz==null) setAttributes(*attributes) else setAttributes(*attributes, "class"[clazz])
        init()
    }
}

/**
 * The summary-tag defines a visible heading for the details-element. The heading can be clicked to view/hide the details.
 */
public class Summary: TextContainer("summary")
