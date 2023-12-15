@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.webkit

//https://www.w3schools.com/cssref/css3_pr_flex-direction.php

public interface FlexDirectionValue {
    public val value: String
}

public enum class FlexDirectionTextValue(public override val value: String): FlexDirectionValue {
    /**
     * Default value. The flexible items are displayed horizontally, as a row.
     */
    row("row"),

    /**
     * Same as row, but in reverse order.
     */
    `row-reverse`("row-reverse"),

    /**
     * The flexible items are displayed vertically, as a column
     */
    column("column"),

    /**
     * Same as column, but in reverse order
     */
    `column-reverse`("column-reverse"),
}

/**
 * The flex-direction property specifies the direction of the flexible items.
 */
public inline var Rule.`flex-direction`: FlexDirectionValue
    get() = FlexDirectionTextValue.row
    set(direction) {
        +Property(
            property = "flex-direction",
            value = direction.value,
            supportedBrowsers = SupportData(
                chrome = 29.0,
                edge = 11.0,
                firefox = 28.0,
                safari = 9.0,
                opera = 17.0,
            )
        ).webkit(SupportDataOverride(
            chrome = 21.0,
            safari = 6.1
        )).moz(SupportDataOverride(
            firefox = 18.0
        ))
    }
