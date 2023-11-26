package template_lib.tags.enums

/**
 * Specifies where to open the linked document.
 */
public enum class Target(public val value: String) {
    /**
     * Opens the linked document in a new window or tab
     */
    BLANK("_blank"),

    /**
     * Opens the linked document in the same frame as it was clicked (this is default)
     */
    SELF("_self"),

    /**
     * Opens the linked document in the parent frame
     */
    PARENT("_parent"),

    /**
     * Opens the linked document in the full body of the window
     */
    TOP("_top"),
}
