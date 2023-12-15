@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.properties.CursorTextValue.AUTO

//https://www.w3schools.com/cssref/pr_class_cursor.php

public interface CursorValue {
    public val value: String
}

public enum class CursorTextValue(public override val value: String): CursorValue {
    /**
     * The cursor indicates an alias of something is to be created
     */
    ALIAS("alias"),

    /**
     * The cursor indicates that something can be scrolled in any direction
     */
    ALL_SCROLL("all-scroll"),

    /**
     * Default. The browser sets a cursor
     */
    AUTO("auto"),

    /**
     * The cursor indicates that a cell (or set of cells) may be selected
     */
    CELL("cell"),

    /**
     * The cursor indicates that the column can be resized horizontally
     */
    COL_RESIZE("col-resize"),

    /**
     * The cursor indicates that a context-menu is available
     */
    CONTEXT_MENU("context-menu"),

    /**
     * The cursor indicates something is to be copied
     */
    COPY("copy"),

    /**
     * The cursor render as a crosshair
     */
    CROSS_HAIR("crosshair"),

    /**
     *The default cursor
     */
    DEFAULT("default"),

    /**
     * The cursor indicates that an edge of a box is to be moved right (east)
     */
    E_RESIZE("e-resize"),

    /**
     * Indicates a bidirectional resize cursor
     */
    EW_RESIZE("ew-resize"),

    /**
     * The cursor indicates that something can be grabbed
     */
    GRAB("grab"),

    /**
     * The cursor indicates that something can be grabbed
     */
    GRABBING("grabbing"),

    /**
     * The cursor indicates that help is available
     */
    HELP("help"),

    /**
     * The cursor indicates something is to be moved
     */
    MOVE("move"),

    /**
     * The cursor indicates that an edge of a box is to be moved up (north)
     */
    N_RESIZE("n-resize"),

    /**
     * The cursor indicates that an edge of a box is to be moved up and right (north/east)
     */
    NE_RESIZE("ne-resize"),

    /**
     * Indicates a bidirectional resize cursor
     */
    NESW_RESIZE("nesw-resize"),

    /**
     * Indicates a bidirectional resize cursor
     */
    NS_RESIZE("ns-resize"),

    /**
     * The cursor indicates that an edge of a box is to be moved up and left (north/west)
     */
    NW_RESIZE("nw-resize"),

    /**
     * Indicates a bidirectional resize cursor
     */
    NWSE_RESIZE("nwse-resize"),

    /**
     * The cursor indicates that the dragged item cannot be dropped here
     */
    NO_DROP("no-drop"),

    /**
     * No cursor is rendered for the element
     */
    NONE("none"),

    /**
     * The cursor indicates that the requested action will not be executed
     */
    NOT_ALLOWED("not-allowed"),

    /**
     * The cursor is a pointer and indicates a link
     */
    POINTER("pointer"),

    /**
     * The cursor indicates that the program is busy (in progress)
     */
    PROGRESS("progress"),

    /**
     * The cursor indicates that the row can be resized vertically
     */
    ROW_RESIZE("row-resize"),

    /**
     * The cursor indicates that an edge of a box is to be moved down (south)
     */
    S_RESIZE("s-resize"),

    /**
     * The cursor indicates that an edge of a box is to be moved down and right (south/east)
     */
    SE_RESIZE("se-resize"),

    /**
     * The cursor indicates that an edge of a box is to be moved down and left (south/west)
     */
    SW_RESIZE("sw-resize"),

    /**
     * The cursor indicates text that may be selected
     */
    TEXT("text"),

    /**
     * A comma separated list of URLs to custom cursors. Note: Always specify a generic cursor at the end of the list, in case none of the URL-defined cursors can be used
     */
    URL("url"),

    /**
     * The cursor indicates vertical-text that may be selected
     */
    VERTICAL_TEXT("vertical-text"),

    /**
     *The cursor indicates that an edge of a box is to be moved left (west)
     */
    W_RESIZE("w-resize"),

    /**
     * The cursor indicates that the program is busy
     */
    WAIT("wait"),

    /**
     * The cursor indicates that something can be zoomed in
     */
    ZOOM_IN("zoom-in"),

    /**
     * The cursor indicates that something can be zoomed out
     */
    ZOOM_OUT("zoom-out"),
}

/**
 * The cursor property specifies the mouse cursor to be displayed when pointing over an element.
 */
public inline var Rule.cursor: CursorValue
    get() = AUTO
    set(content) {
        +Property(
            property = "cursor",
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
