package template.tags

import template.base.TagWithText

public enum class ButtonType(public val value: String) {
    Button("button"),
    Reset("reset")
}

public class Button: TagWithText("button")
