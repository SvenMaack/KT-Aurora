package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class LinkTest {
    @Test
    fun `tag name is link`() {
        val tag = Link()

        assertEquals("link", tag.name)
    }
}