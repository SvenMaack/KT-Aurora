package css_lib.base.browser

fun interface Edge: Browser {
    override val browserName: String
        get() = "edge"
}
