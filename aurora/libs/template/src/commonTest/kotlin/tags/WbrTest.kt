package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class WbrTest {
    @Test
    fun `tag name is wbr`() {
        val tag = Wbr
        assertEquals("wbr", tag.name)
    }
}
