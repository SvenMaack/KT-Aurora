package css.base.browser

public fun interface Firefox: Browser {
    override val browserName: String
        get() = "firefox"
}
