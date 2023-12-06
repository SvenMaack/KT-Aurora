package template.tags

import template.base.TemplatingApi

/**
 * The fieldset-tag is used to group related elements in a form. It draws a box around the related elements.
 */
@OptIn(TemplatingApi::class)
public class Fieldset(id: String): Form(id, "fieldset") {
    /**
     * The legend-tag defines a caption for the fieldset-element.
     */
    public inline fun legend(init: Legend.() -> Unit): Legend = add(Legend()) {
        init()
    }
}
