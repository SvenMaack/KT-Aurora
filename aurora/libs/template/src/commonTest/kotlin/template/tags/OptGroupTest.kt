package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class OptGroupTest {
    @Test
    fun `tag name is optgroup`() {
        val tag = OptGroup()

        assertEquals("optgroup", tag.name)
    }
}
