package navigation

public interface NavigationEntryVM {
    public val name: String
    public val active: Boolean
    public val url: String
}

public interface NavigationVM {
    public val entries: List<NavigationEntryVM>
}
