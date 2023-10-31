package css_lib.properties

import css_lib.base.Rule
import css_lib.properties.*
import kotlin.test.Test
import kotlin.test.assertEquals

class PositionTest {
    @Test
    fun `test position static`() {
        val rule = Rule("selector")
        rule.position(PositionValues.static)

        assertEquals(1, rule.properties.size)
        assertEquals("position", rule.properties[0].property)
        assertEquals("static", rule.properties[0].value)
    }

    @Test
    fun `test position relative`() {
        val rule = Rule("selector")
        rule.position(PositionValues.relative)

        assertEquals(1, rule.properties.size)
        assertEquals("position", rule.properties[0].property)
        assertEquals("relative", rule.properties[0].value)
    }

    @Test
    fun `test position fixed`() {
        val rule = Rule("selector")
        rule.position(PositionValues.fixed)

        assertEquals(1, rule.properties.size)
        assertEquals("position", rule.properties[0].property)
        assertEquals("fixed", rule.properties[0].value)
    }

    @Test
    fun `test position absolute`() {
        val rule = Rule("selector")
        rule.position(PositionValues.absolute)

        assertEquals(1, rule.properties.size)
        assertEquals("position", rule.properties[0].property)
        assertEquals("absolute", rule.properties[0].value)
    }

    @Test
    fun `test position sticky`() {
        val rule = Rule("selector")
        rule.position(PositionValues.sticky)

        assertEquals(1, rule.properties.size)
        assertEquals("position", rule.properties[0].property)
        assertEquals("sticky", rule.properties[0].value)
    }

    @Test
    fun `test top`() {
        val rule = Rule("selector")
        rule.top(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("top", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test right`() {
        val rule = Rule("selector")
        rule.right(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("right", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test bottom`() {
        val rule = Rule("selector")
        rule.bottom(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("bottom", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test left`() {
        val rule = Rule("selector")
        rule.left(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("left", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }
}