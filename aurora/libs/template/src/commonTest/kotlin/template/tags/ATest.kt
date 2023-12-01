package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class ATest {
    @Test
    fun `tag name is a`() {
        val tag = A()

        assertEquals("a", tag.name)
    }
}
