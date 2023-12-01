package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class SectionTest {
    @Test
    fun `tag name is section`() {
        val tag = Section()

        assertEquals("section", tag.name)
    }
}
