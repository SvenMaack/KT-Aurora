package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DataTest {
    @Test
    fun `tag name is data`() {
        val tag = Data()

        assertEquals("data", tag.name)
    }
}
