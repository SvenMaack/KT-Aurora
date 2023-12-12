package navigation

public interface NavigationEntryVM {
    public val name: String
    public val active: Boolean
}

public interface NavigationVM {
    public val entries: List<NavigationEntryVM>
}
