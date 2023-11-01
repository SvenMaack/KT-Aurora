package css_lib.base.browser

fun interface Safari: Browser {
    override val browserName: String
        get() = "safari"
}
