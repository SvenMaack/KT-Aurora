package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class BaseTest {
    @Test
    fun `tag name is base`() {
        val tag = Base()

        assertEquals("base", tag.name)
    }
}
