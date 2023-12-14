package landingPage.domain

private data class DummyNavigationEntry(
    override val name: String,
    override val active: Boolean = false
) : NavigationEntry

private data class DummyNavigation(
    override val entries: List<NavigationEntry>
): Navigation

internal class NavigationProvider: INavigationProvider {
    override suspend fun getNavigation(): Navigation {
        return DummyNavigation(
            listOf(
                DummyNavigationEntry("Home", active = true),
                DummyNavigationEntry("Men"),
                DummyNavigationEntry("Women"),
                DummyNavigationEntry("Kids"),
                DummyNavigationEntry("Collection"),
                DummyNavigationEntry("Trends"),
            )
        )
    }
}