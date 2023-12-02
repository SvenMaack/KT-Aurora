package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class OptionTest {
    @Test
    fun `tag name is option`() {
        val tag = Option()

        assertEquals("option", tag.name)
    }
}
