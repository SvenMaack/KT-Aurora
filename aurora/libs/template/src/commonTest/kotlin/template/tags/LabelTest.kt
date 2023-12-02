package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class LabelTest {
    @Test
    fun `tag name is label`() {
        val tag = Label()

        assertEquals("label", tag.name)
    }
}
