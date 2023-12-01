package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class CiteTest {
    @Test
    fun `tag name is cite`() {
        val tag = Cite()

        assertEquals("cite", tag.name)
    }
}
