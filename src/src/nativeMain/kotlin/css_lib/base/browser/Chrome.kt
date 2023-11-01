package css_lib.base.browser

fun interface Chrome: Browser {
    override val browserName: String
        get() = "chrome"
}
