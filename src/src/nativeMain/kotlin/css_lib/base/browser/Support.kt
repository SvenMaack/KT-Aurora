package css_lib.base.browser

interface Support {
    val support: List<Browser>
}

class SupportImpl (
    chrome: Chrome,
    edge: Edge,
    firefox: Firefox,
    opera: Opera,
    safari: Safari,
): Support {
    override val support: List<Browser>

    init {
        support = listOf(
            chrome,
            edge,
            firefox,
            opera,
            safari
        )
    }
}
