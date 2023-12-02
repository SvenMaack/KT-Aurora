package css.base.browser
public fun interface Opera: Browser {
    override val browserName: String
        get() = "opera"
}
