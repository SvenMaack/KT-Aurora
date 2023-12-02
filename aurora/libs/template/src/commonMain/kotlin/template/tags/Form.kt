package template.tags

public enum class AutoComplete(public val value: String) {
    ON("on"),
    OFF("off")
}

public enum class Method(public val value: String) {
    GET("get"),
    POST("post")
}

@kotlin.Suppress("EnumEntryName")
public enum class EncType(public val value: String) {
    Application_x_www_form_urlencoded("application/x-www-form-urlencoded"),
    Multipart_form_data("multipart/form-data"),
    Text_plain("text/plain")
}

public class Form: BodyTagContainer("form")
