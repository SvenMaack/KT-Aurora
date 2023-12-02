package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class InputTest {
    @Test
    fun `tag name is input`() {
        val tag = Input()

        assertEquals("input", tag.name)
    }
}
