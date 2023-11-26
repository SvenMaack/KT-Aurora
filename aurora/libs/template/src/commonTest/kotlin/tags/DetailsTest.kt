package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DetailsTest {
    @Test
    fun `tag name is details`() {
        val tag = Details()
        assertEquals("details", tag.name)
    }
}
