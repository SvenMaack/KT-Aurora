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
                DummyNavigationEntry("Home"),
                DummyNavigationEntry("Trends", active = true),
                DummyNavigationEntry("New Arrival"),
                DummyNavigationEntry("Sales")
            )
        )
    }
}