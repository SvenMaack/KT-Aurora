package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun `tag name is main`() {
        val tag = Main()

        assertEquals("main", tag.name)
    }
}
