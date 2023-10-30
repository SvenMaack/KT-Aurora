package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class NavTest {
    @Test
    fun `test tag name is nav`() {
        val tag = Nav()
        assertEquals("nav", tag.name)
    }
}
