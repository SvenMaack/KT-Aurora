@file:Suppress("FunctionName", "TopLevelPropertyNaming", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public interface FontSizeValue {
    public val value: String
}

public enum class FontSizeTextValue(public override val value: String): FontSizeValue {
    /**
     * Sets the font-size to a medium size. This is default
     */
    medium("medium"),

    /**
     * 	Sets the font-size to a xx-small size
     */
    `xx-small`("xx-small"),

    /**
     * 	Sets the font-size to a tiny size
     */
    `x-small`("x-small"),

    /**
     * 	Sets the font-size to a small size
     */
    small("small"),

    /**
     * Sets the font-size to a large size
     */
    large("large"),

    /**
     *	Sets the font-size to an extra large size
     */
    `x-large`("x-large"),

    /**
     * Sets the font-size to a xx-large size
     */
    `xx-large`("medium"),

    /**
     * Sets the font-size to a smaller size than the parent element
     */
    smaller("smaller"),

    /**
     * Sets the font-size to a larger size than the parent element
     */
    larger("larger"),
}

/**
 * The font-size property sets the size of a font.
 */
public inline var Rule.`font-size`: Size
    get() = 0.px
    set(size) {
        +Property(
            property = "font-size",
            value = size.toString(),
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 5.5,
                firefox = 1.0,
                safari = 1.0,
                opera = 7.0
            )
        )
    }

/**
 * The font-size property sets the size of a font.
 */
public fun Rule.`font-size`(value: FontSizeValue) {
    +Property(
        property = "font-size",
        value = value.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 5.5,
            firefox = 1.0,
            safari = 1.0,
            opera = 7.0
        )
    )
}
