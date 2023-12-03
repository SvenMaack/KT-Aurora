package template.tags

public enum class IFrameLoading(public val value: String) {
    EAGER("eager"),
    LAZY("lazy")
}

public enum class IFrameSandbox(public val value: String) {
    All(""),
    AllowForms("allow-forms"),
    AllowPointerLock("allow-pointer-lock"),
    AllowPopups("allow-popups"),
    AllowSameOrigin("allow-same-origin"),
    AllowScripts("allow-scripts"),
    AllowTopNavigation("allow-top-navigation"),
}

/**
 * The iframe-tag specifies an inline frame.
 */
public class IFrame: BodyTagContainer("iframe")
