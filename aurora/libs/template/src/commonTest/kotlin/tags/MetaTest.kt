package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class MetaTest {
    @Test
    fun `test tag name is meta`() {
        val tag = Meta()
        assertEquals("meta", tag.name)
    }
}
