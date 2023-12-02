package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SearchTest {
    @Test
    fun `tag name is search`() {
        val tag = Search()

        assertEquals("search", tag.name)
    }
}
