package css.properties

import css.properties.Zero.unaryMinus
import kotlin.test.Test
import kotlin.test.assertEquals

class SizeTest {
    @Test
    fun `size creation works`() {
        val size = ValueSize("2", CssUnit.px)
        assertEquals("2px", size.toString())
    }

    @Test
    fun `create negative size works`() {
        val size = ValueSize("2", CssUnit.px)
        assertEquals("-2px", (-size).toString())
    }

    @Test
    fun `create positive size works`() {
        val size = ValueSize("2", CssUnit.px)
        assertEquals("2px", (-(-size)).toString())
    }

    @Test
    fun `create 0 works`() {
        assertEquals("0", Zero.toString())
    }
}
