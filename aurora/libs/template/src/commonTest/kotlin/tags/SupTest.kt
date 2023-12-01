package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SupTest {
    @Test
    fun `tag name is sup`() {
        val tag = Sup()

        assertEquals("sup", tag.name)
    }
}
