package css.properties

import kotlin.test.Test
import kotlin.test.assertEquals

class SizeTest {
    @Test
    fun `test value size`() {
        val size = ValueSize("2", CssUnit.px)
        assertEquals("2px", size.toString())
    }

    @Test
    fun `test negative value size`() {
        val size = -ValueSize("2", CssUnit.px)
        assertEquals("-2px", size.toString())
    }
}
