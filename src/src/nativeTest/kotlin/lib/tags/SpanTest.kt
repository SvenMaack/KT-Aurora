package lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SpanTest {
    @Test
    fun `test tag name is span`() {
        val tag = Span()
        assertEquals("span", tag.name)
    }
}
