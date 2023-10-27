package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class BodyTest {
    @Test
    fun `test tag name is body`() {
        val tag = Body()
        assertEquals("body", tag.name)
    }
}
