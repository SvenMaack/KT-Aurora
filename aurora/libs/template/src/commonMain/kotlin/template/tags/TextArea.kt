package template.tags

public enum class Wrap(public val value: String) {
    Hard("hard"),
    Soft("soft")
}

/**
 * The textarea-tag defines a multi-line text input control.
 */
public class TextArea(override val id: String) : BodyTagContainer("textarea"), FormElement
