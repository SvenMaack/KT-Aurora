package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DivTest {
    @Test
    fun `test tag name is div`() {
        val tag = Div()
        assertEquals("div", tag.name)
    }
}
