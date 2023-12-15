@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.BeforeAfterRule
import css.base.Property
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
    `no-close-quote`("no-close-quote")
}

public class ContentUrl(url: String): ContentValue {
    override val value: String =
        "url($url)"
}

public class ContentAttribute(attribute: String): ContentValue {
    override val value: String =
        "attr($attribute)"
}

public data class ContentCustom(public override val value: String): ContentValue

/**
 * The content property is used with the ::before and ::after pseudo-elements, to insert generated content.
 */
public inline var BeforeAfterRule.content: ContentValue
    get() = ContentCustom("\"\"")
    set(content) {
        +Property(
            property = "content",
            value = content.value,
            supportedBrowsers = SupportData(
                chrome = 1.0,
                edge = 8.0,
                firefox = 1.0,
                safari = 1.0,
                opera = 4.0,
            )
        )
    }
