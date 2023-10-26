package lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class PTest {
    @Test
    fun `test tag name is p`() {
        val tag = P()
        assertEquals("p", tag.name)
    }
}
