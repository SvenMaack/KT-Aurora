package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class ButtonTest {
    @Test
    fun `tag name is button`() {
        val tag = Button()

        assertEquals("button", tag.name)
    }
}
