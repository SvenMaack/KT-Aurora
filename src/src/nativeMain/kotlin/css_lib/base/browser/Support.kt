package css_lib.base.browser

interface Support {
    val supportedBrowsers: List<Browser>
}

class SupportImpl (
    chrome: Chrome,
    edge: Edge,
    firefox: Firefox,
    opera: Opera,
    safari: Safari,
): Support {
    override val supportedBrowsers: List<Browser>

    init {
        supportedBrowsers = listOf(
            chrome,
            edge,
            firefox,
            opera,
            safari
        )
    }
}
