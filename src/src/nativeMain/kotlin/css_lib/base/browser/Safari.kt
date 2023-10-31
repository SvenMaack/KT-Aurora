package css_lib.base.browser

fun interface Safari: Browser {
    override fun browserName(): String = "safari"
}
