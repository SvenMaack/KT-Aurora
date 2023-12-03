package template.tags

/**
 * The fieldset-tag is used to group related elements in a form. It draws a box around the related elements.
 */
public class Fieldset(id: String): Form(id, "fieldset") {
    /**
     * The legend-tag defines a caption for the fieldset-element.
     */
    public inline fun legend(init: Legend.() -> Unit): Legend = add(Legend()) {
        init()
    }
}
