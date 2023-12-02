package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class LegendTest {
    @Test
    fun `tag name is legend`() {
        val tag = Legend()

        assertEquals("legend", tag.name)
    }
}
