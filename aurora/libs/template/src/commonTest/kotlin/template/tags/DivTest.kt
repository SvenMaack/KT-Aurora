package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DivTest {
    @Test
    fun `tag name is div`() {
        val tag = Div()

        assertEquals("div", tag.name)
    }
}
