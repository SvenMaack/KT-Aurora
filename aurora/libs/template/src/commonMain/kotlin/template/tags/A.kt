package template.tags

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

/**
 * Specifies which referrer information to send with the link
 */
public enum class ReferrerPolicy(public val value: String) {
    /**
     * No referrer information is sent
     */
    NO_REFERRER("no-referrer"),

    /**
     * Default. Sends the origin, path, and query string if the protocol security level stays the same or is higher (HTTP to HTTP, HTTPS to HTTPS, HTTP to HTTPS is ok). Sends nothing to less secure level (HTTPS to HTTP is not ok)
     */
    NO_REFERRER_WHEN_DOWNGRADE("no-referrer-when-downgrade"),

    /**
     * Sends the origin (scheme, host, and port) of the document
     */
    ORIGIN("origin"),

    /**
     * Sends the origin of the document for cross-origin request. Sends the origin, path, and query string for same-origin request
     */
    ORIGIN_WHEN_CROSS_ORIGIN("origin-when-cross-origin"),

    /**
     * Sends a referrer for same-origin request. Sends no referrer for cross-origin request
     */
    SAME_ORIGIN("same-origin"),

    /**
     * Sends the origin if the protocol security level stays the same or is higher (HTTP to HTTP, HTTPS to HTTPS, and HTTP to HTTPS is ok). Sends nothing to less secure level (HTTPS to HTTP)
     */
    STRICT_ORIGIN_WHEN_CROSS_ORIGIN("strict-origin-when-cross-origin"),

    /**
     * Sends the origin, path, and query string (regardless of security). Use this value carefully!
     */
    @Deprecated(message = "For Security Reasons")
    UNSAFE_URL("unsafe-url")
}

public class A: BodyTagContainer("a")
