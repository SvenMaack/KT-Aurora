package css.base.browser

public fun interface Edge: Browser {
    override val browserName: String
        get() = "edge"
}
