@file:Suppress("TopLevelPropertyNaming", "TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "CyclomaticComplexMethod", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_list-style-image.php

public interface ListStyleImageValue {
    public val value: String
}

public enum class ListStyleImageTextValue(public override val value: String): ListStyleImageValue {
    none("none"),
}

/**
 * The list-style-position property specifies the position of the list-item markers (bullet points).
 */
public inline var Rule.`list-style-image`: ListStyleImageValue
    get() = ListStyleImageTextValue.none
    set(image) {
        +Property(
            property = "list-style-image",
            value = image.value,
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
 * The list-style-image property replaces the list-item marker with an image.
 */
public fun Rule.`list-style-image`(url: String) {
    +Property(
        property = "list-style-image",
        value = "url(\"$url\")",
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = 7.0,
        )
    )
}
