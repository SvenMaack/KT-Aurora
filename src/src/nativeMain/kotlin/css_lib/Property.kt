package css_lib

data class Property(
    val property: String,
    val value: String
) {
    override fun toString(): String =
        "$property:$value;"
}
