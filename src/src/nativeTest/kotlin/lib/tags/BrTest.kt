package lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class BrTest {
    @Test
    fun `test tag name is body`() {
        val tag = Br
        assertEquals("br", tag.name)
    }
}
