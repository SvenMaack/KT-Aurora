package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class AsideTest {
    @Test
    fun `tag name is aside`() {
        val tag = Aside()

        assertEquals("aside", tag.name)
    }
}
