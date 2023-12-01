package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class TimeTest {
    @Test
    fun `tag name is time`() {
        val tag = Time()

        assertEquals("time", tag.name)
    }
}
