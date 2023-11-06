package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class LinkTest {
    @Test
    fun `test tag name is link`() {
        val tag = Link()
        assertEquals("link", tag.name)
    }
}