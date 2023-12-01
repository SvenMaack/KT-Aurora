package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class VarTest {
    @Test
    fun `tag name is var`() {
        val tag = Var()

        assertEquals("var", tag.name)
    }
}
