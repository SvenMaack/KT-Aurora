package css_lib.base.browser

fun interface Firefox: Browser {
    override fun browserName(): String = "firefox"
}
