package lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DocTypeTest {
    @Test
    fun `test tag name is body`() {
        val tag = DocType
        assertEquals("!DOCTYPE html", tag.name)
    }
}
