package css.properties

import kotlin.test.Test
import kotlin.test.assertEquals

class SizeTest {
    @Test
    fun `size creation works`() {
        val size = ValueSize("2", CssUnit.px)
        assertEquals("2px", size.toString())
    }
}
