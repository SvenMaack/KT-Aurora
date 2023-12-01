package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class OutputTest {
    @Test
    fun `tag name is output`() {
        val tag = Output()

        assertEquals("output", tag.name)
    }
}
