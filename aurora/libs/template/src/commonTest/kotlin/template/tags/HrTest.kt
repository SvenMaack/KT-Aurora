package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class HrTest {
    @Test
    fun `tag name is hr`() {
        val tag = Hr

        assertEquals("hr", tag.name)
    }
}
