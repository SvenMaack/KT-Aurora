package css_lib.base.browser

fun interface Opera: Browser {
    override fun browserName(): String = "opera"
}
