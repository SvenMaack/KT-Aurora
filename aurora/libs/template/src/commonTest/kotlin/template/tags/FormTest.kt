package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class FormTest {
    @Test
    fun `tag name is form`() {
        val tag = Form()

        assertEquals("form", tag.name)
    }
}
