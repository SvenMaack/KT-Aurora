@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData

//https://www.w3schools.com/cssref/pr_gen_content.php

public interface ContentValue {
    public val value: String
}

public enum class ContentTextValue(public override val value: String): ContentValue {
    /**
     * Default value. Sets the content, if specified, to normal, which default is "none" (which is nothing)
     */
    normal("normal"),

    /**
     * Sets the content, if specified, to nothing
     */
    none("none"),

    /**
     * Sets the content as a counter
     */
    counter("counter"),

    /**
     * Sets the content to be an opening quote
     */
    `open-quote`("open-quote"),

    /**
     * Sets the content to be a closing quote
     */
    `close-quote`("close-quote"),

    /**
     * Removes the opening quote from the content, if specified
     */
    `no-open-quote`("no-open-quote"),

    /**
     * Removes the closing quote from the content, if specified
     */
    `no-close-quote`("no-close-quote"),

    /**
     * 	Sets this property to its default value.
     */
    initial("initial"),

    /**
     * Inherits this property from its parent element.
     */
    inherit("inherit"),
}

public class ContentUrl(url: String): ContentValue {
    override val value: String =
        "url($url)"
}

public class ContentAttribute(attribute: String): ContentValue {
    override val value: String =
        "attr($attribute)"
}

private val browserSupport = SupportData(
    chrome = 1.0,
    edge = 8.0,
    firefox = 1.0,
    safari = 1.0,
    opera = 4.0,
)

/**
 * The content property is used with the ::before and ::after pseudo-elements, to insert generated content.
 */
public fun Rule.content(content: ContentValue) {
    +Property(
        property = "content",
        value = content.value,
        supportedBrowsers = browserSupport
    )
}

/**
 * The content property is used with the ::before and ::after pseudo-elements, to insert generated content.
 */
public fun Rule.content(content: String) {
    +Property(
        property = "content",
        value = content,
        supportedBrowsers = browserSupport
    )
}
