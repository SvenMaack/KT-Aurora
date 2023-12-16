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
                DummyNavigationEntry("Home", url = "/?id=1", active = "/?id=1" == currentPath),
                DummyNavigationEntry("Men", url = "/?id=2", active = "/?id=2" == currentPath),
                DummyNavigationEntry("Women", url = "/?id=3", active = "/?id=3" == currentPath),
                DummyNavigationEntry("Kids", url = "/?id=4", active = "/?id=4" == currentPath),
                DummyNavigationEntry("Collection", url = "/?id=5", active = "/?id=5" == currentPath),
                DummyNavigationEntry("Trends", url = "/?id=6", active = "/?id=6" == currentPath),
            )
        )
    }
}
