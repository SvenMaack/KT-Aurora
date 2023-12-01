package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class EmTest {
    @Test
    fun `tag name is em`() {
        val tag = Em()

        assertEquals("em", tag.name)
    }
}
