package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class PTest {
    @Test
    fun `tag name is p`() {
        val tag = P()
        assertEquals("p", tag.name)
    }
}
