package template.tags.enums

@Suppress("EnumEntryName")
public enum class EncType(public val value: String) {
    Application_x_www_form_urlencoded("application/x-www-form-urlencoded"),
    Multipart_form_data("multipart/form-data"),
    Text_plain("text/plain")
}
