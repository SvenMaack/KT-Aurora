package template.tags

public enum class Wrap(public val value: String) {
    Hard("hard"),
    Soft("soft")
}

public class TextArea(override val id: String) : BodyTagContainer("textarea"), FormElement
