package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class TitleTest {
    @Test
    fun `tag name is title`() {
        val tag = Title()

        assertEquals("title", tag.name)
    }
}
