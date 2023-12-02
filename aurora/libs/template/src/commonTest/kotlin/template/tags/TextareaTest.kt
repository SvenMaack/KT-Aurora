package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class TextareaTest {
    @Test
    fun `tag name is textarea`() {
        val tag = TextArea("id1")

        assertEquals("textarea", tag.name)
        assertEquals("id1", tag.id)
    }
}
