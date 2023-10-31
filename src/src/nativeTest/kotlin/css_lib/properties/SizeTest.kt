package css_lib.properties

import css_lib.properties.*
import kotlin.test.Test
import kotlin.test.assertEquals

class SizeTest {
    @Test
    fun `test value size`() {
        val size = ValueSize(2, CssUnit.px)
        assertEquals("2px", size.toString())
    }

    @Test
    fun `test negative value size`() {
        val size = -ValueSize(2, CssUnit.px)
        assertEquals("-2px", size.toString())
    }

    @Test
    fun `test floating value size`() {
        val size = FloatingValueSize(2.0, CssUnit.px)
        assertEquals("2.0px", size.toString())
    }

    @Test
    fun `test negative floating value size`() {
        val size = -FloatingValueSize(2.0, CssUnit.px)
        assertEquals("-2.0px", size.toString())
    }

    @Test
    fun `test auto size`() {
        assertEquals("auto", auto.toString())
    }

    @Test
    fun `test inherit size`() {
        assertEquals("inherit", inherit.toString())
    }
}