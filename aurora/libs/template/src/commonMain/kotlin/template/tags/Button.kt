package template.tags

import template.base.TagWithText

public enum class ButtonType(public val value: String) {
    Button("button"),
    Reset("reset"),
    @Deprecated("Use submit function instead", ReplaceWith("submit"))
    Submit("submit")
}

/**
 * The button-tag defines a clickable button.
 */
public class Button: TagWithText("button")
