package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class HrTest {
    @Test
    fun `test tag name is hr`() {
        val tag = Hr
        assertEquals("hr", tag.name)
    }
}
