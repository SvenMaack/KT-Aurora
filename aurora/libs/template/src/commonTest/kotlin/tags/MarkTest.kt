package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class MarkTest {
    @Test
    fun `tag name is mark`() {
        val tag = Mark()

        assertEquals("mark", tag.name)
    }
}
