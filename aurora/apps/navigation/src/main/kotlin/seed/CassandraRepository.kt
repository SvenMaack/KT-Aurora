package seed

import java.util.*

internal class CassandraRepository(private val connection: DbConnection): Repository {
    override fun getEntries(): List<MenuEntry> {
        return listOf(MenuEntry(
            1,
            "en",
            UUID.randomUUID(),
            "Women" ,
            "/landingpage?id=3"
        ))
    }
}
