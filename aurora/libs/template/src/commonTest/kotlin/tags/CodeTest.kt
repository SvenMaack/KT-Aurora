package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class CodeTest {
    @Test
    fun `tag name is code`() {
        val tag = Code()
        assertEquals("code", tag.name)
    }
}
