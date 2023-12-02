package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class IFrameTest {
    @Test
    fun `tag name is iframe`() {
        val tag = IFrame()

        assertEquals("iframe", tag.name)
    }
}
