package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SelectTest {
    @Test
    fun `tag name is select`() {
        val tag = Select("id1")

        assertEquals("select", tag.name)
        assertEquals("id1", tag.id)
    }
}
