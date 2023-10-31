package css_lib.base.browser

fun interface Chrome: Browser {
    override fun browserName(): String = "chrome"
}
