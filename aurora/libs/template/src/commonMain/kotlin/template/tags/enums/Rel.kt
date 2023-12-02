package template.tags.enums

/**
 * Specifies the relationship between the current document and the linked document.
 */
public enum class Rel(public val value: String) {
    /**
     * 	Provides a link to an alternate representation of the document (i.e. print page, translated or mirror)
     */
    ALTERNATE("alternate"),

    /**
     * Provides a link to the author of the document
     */
    AUTHOR("author"),

    /**
     * Permanent URL used for bookmarking
     */
    BOOKMARK("bookmark"),

    /**
     * External	Indicates that the referenced document is not part of the same site as the current document
     */
    EXTERNAL("external"),

    /**
     * Provides a link to a help document
     */
    HELP("help"),

    /**
     * Provides a link to licensing information for the document
     */
    LICENSE("license"),

    /**
     * Provides a link to the next document in the series
     */
    NEXT("next"),

    /**
     * Links to an unendorsed document, like a paid link.
     */
    NOFOLLOW("nofollow"),

    /**
     * Requires that any browsing context created by following the hyperlink must not have an opener browsing context
     */
    NO_OPENER("noopener"),

    /**
     * Makes the referrer unknown. No referer header will be included when the user clicks the hyperlink
     */
    NO_REFERRER("noreferrer"),

    /**
     * The previous document in a selection
     */
    PREV("prev"),

    /**
     * Links to a search tool for the document
     */
    SEARCH("search"),

    /**
     * A tag (keyword) for the current document
     */
    TAG("tag")
}
