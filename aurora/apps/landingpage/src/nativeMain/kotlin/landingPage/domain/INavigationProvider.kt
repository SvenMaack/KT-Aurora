package landingPage.domain

public interface NavigationEntry {
    public val name: String
    public val active: Boolean
    public val url: String
}

public interface Navigation {
    public val entries: List<NavigationEntry>
}

internal interface INavigationProvider {
    suspend fun getNavigation(currentPath: String): Navigation
}
