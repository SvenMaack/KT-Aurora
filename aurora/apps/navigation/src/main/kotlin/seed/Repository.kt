package seed

internal fun interface Repository {
    fun getEntries(): List<MenuEntry>
}
