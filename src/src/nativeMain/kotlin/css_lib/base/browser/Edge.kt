package css_lib.base.browser

fun interface Edge: Browser {
    override fun browserName(): String = "edge"
}
