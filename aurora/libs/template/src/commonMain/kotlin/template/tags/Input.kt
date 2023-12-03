package template.tags

import template.base.TagWithAttributes

public enum class InputType(public val value: String) {
    @Deprecated("Use button instead")
    Button("button"),
    Checkbox("checkbox"),
    Color("color"),
    Date("date"),
    DateTimeLocal("datetime-local"),
    Email("email"),
    File("file"),
    Hidden("hidden"),
    Month("month"),
    Number("number"),
    Password("password"),
    Radio("radio"),
    Range("range"),
    Reset("reset"),
    Search("search"),
    @Deprecated("Use submit button instead")
    Submit("submit"),
    Tel("tel"),
    Text("text"),
    Time("time"),
    Url("url"),
    Week("week"),
}

public class Input: TagWithAttributes("input")
