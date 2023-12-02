package css.base.browser

public interface Support {
    public val supportedBrowsers: List<Browser>
}

public class SupportImpl (
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
