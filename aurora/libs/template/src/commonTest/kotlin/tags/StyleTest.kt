package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class StyleTest {
    @Test
    fun `test tag name is style`() {
        val tag = Style()
        assertEquals("style", tag.name)
    }
}
