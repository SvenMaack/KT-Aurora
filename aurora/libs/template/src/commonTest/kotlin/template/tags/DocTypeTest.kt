package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DocTypeTest {
    @Test
    fun `test tag name is doctype`() {
        val tag = DocType

        assertEquals("!DOCTYPE html", tag.name)
    }
}
