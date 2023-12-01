package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SpanTest {
    @Test
    fun `tag name is span`() {
        val tag = Span()

        assertEquals("span", tag.name)
    }
}
