package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class MetaTest {
    @Test
    fun `tag name is meta`() {
        val tag = Meta()

        assertEquals("meta", tag.name)
    }
}
