package css_lib.base.browser

fun interface Firefox: Browser {
    override val browserName: String
        get() = "firefox"
}
