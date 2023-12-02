package css.base.browser

public fun interface Safari: Browser {
    override val browserName: String
        get() = "safari"
}
