package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class AbbrTest {
    @Test
    fun `tag name is abbr`() {
        val tag = Abbr()

        assertEquals("abbr", tag.name)
    }
}
