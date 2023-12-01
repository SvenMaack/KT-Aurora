package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class DfnTest {
    @Test
    fun `tag name is dfn`() {
        val tag = Dfn()

        assertEquals("dfn", tag.name)
    }
}
