package css.base.browser

public fun interface Chrome: Browser {
    override val browserName: String
        get() = "chrome"
}
