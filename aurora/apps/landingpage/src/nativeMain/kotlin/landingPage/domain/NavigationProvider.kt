package landingPage.domain

private data class DummyNavigationEntry(
    override val name: String,
    override val active: Boolean = false,
    override val url: String
) : NavigationEntry

private data class DummyNavigation(
    override val entries: List<NavigationEntry>
): Navigation

internal class NavigationProvider: INavigationProvider {
    override suspend fun getNavigation(currentPath: String): Navigation {
        return DummyNavigation(
            listOf(
                DummyNavigationEntry("Home", url = "/?id=1"),
                DummyNavigationEntry("Men", url = "/?id=2"),
                DummyNavigationEntry("Women", url = "/?id=3"),
                DummyNavigationEntry("Kids", url = "/?id=4"),
                DummyNavigationEntry("Collection", url = "/?id=5"),
                DummyNavigationEntry("Trends", url = "/?id=6"),
            ).map {
                it.copy(active = currentPath.startsWith(it.url))
            }
        )
    }
}
