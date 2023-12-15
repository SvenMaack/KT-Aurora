@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "CyclomaticComplexMethod", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_list-style-type.php

public interface ListStyleTypeValue {
    public val value: String
}

public enum class ListStyleTypeTextValue(public override val value: String): ListStyleTypeValue {
    disc("disc"),
    armenian("armenian"),
    circle("circle"),
    `cjk-ideographic`("cjk-ideographic"),
    decimal("decimal"),
    `decimal-leading-zero`("decimal-leading-zero"),
    georgian("georgian"),
    hebrew("hebrew"),
    hiragana("hiragana"),
    `hiragana-iroha`("hiragana-iroha"),
    katakana("katakana"),
    `katakana-iroha`("katakana-iroha"),
    `lower-alpha`("lower-alpha"),
    `lower-greek`("lower-greek"),
    `lower-latin`("lower-latin"),
    `lower-roman`("lower-roman"),
    none("none"),
    square("square"),
    `upper-alpha`("upper-alpha"),
    `upper-greek`("upper-greek"),
    `upper-latin`("upper-latin"),
    `upper-roman`("upper-roman")
}

/**
 * The list-style-type specifies the type of list-item marker in a list.
 */
public inline var Rule.`list-style-type`: ListStyleTypeValue
    get() = ListStyleTypeTextValue.disc
    set(type) {
        +Property(
            property = "list-style-type",
            value = type.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 4.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 3.5,
            )
        )
    }
