@file:Suppress("TopLevelPropertyNaming", "FunctionName", "EnumEntryName", "EnumNaming", "CyclomaticComplexMethod", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList", "ObjectPropertyName")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_list-style.php

public interface ListStyleValue {
    public val value: String
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue, image: ListStyleImageValue) {
    setListStyle(type, position, image.value)
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue, url: String) {
    setListStyle(type, position, "url(\"$url\")")
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(position: ListStylePositionValue, image: ListStyleImageValue) {
    setListStyle(null, position, image.value)
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(position: ListStylePositionValue, url: String) {
    setListStyle(null, position, "url(\"$url\")")
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(type: ListStyleTypeValue, image: ListStyleImageValue) {
    setListStyle(type, null, image.value)
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(type: ListStyleTypeValue, url: String) {
    setListStyle(type, null, "url(\"$url\")")
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(type: ListStyleTypeValue, position: ListStylePositionValue) {
    setListStyle(type, position, null)
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(image: ListStyleImageValue) {
    setListStyle(null, null, image.value)
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(url: String) {
    setListStyle(null, null, "url(\"$url\")")
}

/**
 * The list-style property is a shorthand
 */
public fun Rule.`list-style`(position: ListStylePositionValue) {
    setListStyle(null, position, null)
}

/**
 * The list-style property is a shorthand
 */
public var Rule.`list-style`: ListStyleTypeValue
    get() = inherit
    set(style) {
        setListStyle(style, null, null)
    }

private fun Rule.setListStyle(type: ListStyleTypeValue?, position: ListStylePositionValue?, image: String?) {
    +Property(
        property = "list-style",
        value = "${type?.value ?: ""} ${position?.value ?: ""} ${image ?: ""}".replace("  ", " ").trim(),
        supportedBrowsers = SupportData(
            chrome = 1.0,
            edge = 4.0,
            firefox = 1.0,
            safari = 1.0,
            opera = if(image==null) 3.5 else 7.0,
        )
    )
}
