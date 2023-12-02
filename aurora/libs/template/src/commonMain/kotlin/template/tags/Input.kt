package template.tags

import template.base.TagWithAttributes

public enum class InputType(public val value: String) {
    Checkbox("checkbox"),
    Color("color"),
    Date("date"),
    DateTimeLocal("datetime-local"),
    Email("email"),
    Hidden("hidden"),
    Month("month"),
    Number("number"),
    Password("password"),
    Radio("radio"),
    Range("range"),
    Reset("reset"),
    Search("search"),
    Tel("tel"),
    Text("text"),
    Time("time"),
    Url("url"),
    Week("week"),
}

public class Input: TagWithAttributes("input")
