package css_lib.base.browser

fun interface Opera: Browser {
    override val browserName: String
        get() = "opera"
}
