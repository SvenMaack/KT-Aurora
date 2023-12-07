package navigation

public data class NavigationEntry(
    val name: String,
    val active: Boolean
)

public data class NavigationVM(
    val entries: List<NavigationEntry>
)
