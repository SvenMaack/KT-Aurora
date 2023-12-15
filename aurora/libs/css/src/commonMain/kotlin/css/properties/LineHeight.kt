@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

public interface LineHeightValue {
    public val value: String
}

public enum class LineHeightTextValue(public override val value: String): LineHeightValue {
    normal("normal")
}

/**
 * The line-height property specifies the height of a line.
 */
public inline var Rule.`line-height`: Double
    get() = 0.0
    set(size) {
        +Property(
            property = "line-height",
            value = size.toString(),
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 7.0,
            )
        )
    }

/**
 * The line-height property specifies the height of a line.
 */
public fun Rule.`line-height`(size: LineHeightValue) {
    +Property(
        property = "line-height",
        value = size.value,
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 7.0,
        )
    )
}
