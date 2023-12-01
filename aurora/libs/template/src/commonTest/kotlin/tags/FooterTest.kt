package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class FooterTest {
    @Test
    fun `tag name is footer`() {
        val tag = Footer()

        assertEquals("footer", tag.name)
    }
}
