@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "CyclomaticComplexMethod", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.ListStylePositionTextValue.outside

//https://www.w3schools.com/cssref/pr_list-style-position.php

public interface ListStylePositionValue {
    public val value: String
}

public enum class ListStylePositionTextValue(public override val value: String): ListStylePositionValue {
    inside("inside"),
    outside("outside")
}

/**
 * The list-style-position property specifies the position of the list-item markers (bullet points).
 */
public inline var Rule.`list-style-position`: ListStylePositionValue
    get() = outside
    set(position) {
        +Property(
            property = "list-style-position",
            value = position.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5
            )
        )
    }
