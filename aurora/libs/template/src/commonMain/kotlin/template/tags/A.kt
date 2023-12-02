package template.tags

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
