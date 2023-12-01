package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class PreTest {
    @Test
    fun `tag name is pre`() {
        val tag = Pre()

        assertEquals("pre", tag.name)
    }
}
