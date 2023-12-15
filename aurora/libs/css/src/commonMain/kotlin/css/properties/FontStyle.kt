@file:Suppress("FunctionName", "TopLevelPropertyNaming", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public interface FontStyleValue {
    public val value: String
}

public enum class FontStyleTextValue(public override val value: String): FontStyleValue {
    /**
     * The browser displays a normal font style. This is default.
     */
    normal("normal"),

    /**
     * The browser displays an italic font style
     */
    italic("italic"),

    /**
     * The browser displays an oblique font style
     */
    oblique("oblique")
}

/**
 * The font-style property specifies the font style for a text.
 */
public inline var Rule.`font-style`: FontStyleValue
    get() = FontStyleTextValue.normal
    set(style) {
        +Property(
            property = "font-style",
            value = style.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 7.0,
            )
        )
    }
