package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SubTest {
    @Test
    fun `tag name is sub`() {
        val tag = Sub()

        assertEquals("sub", tag.name)
    }
}
