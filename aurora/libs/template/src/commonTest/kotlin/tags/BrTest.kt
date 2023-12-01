package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class BrTest {
    @Test
    fun `tag name is br`() {
        val tag = Br

        assertEquals("br", tag.name)
    }
}
