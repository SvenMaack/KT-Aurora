package css_lib

import kotlin.test.Test
import kotlin.test.assertEquals

class MarginTest {
    @Test
    fun `test margin`() {
        val rule = Rule("selector")
        rule.margin(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-top`() {
        val rule = Rule("selector")
        rule.`margin-top`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-top", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-right`() {
        val rule = Rule("selector")
        rule.`margin-right`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-right", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-bottom`() {
        val rule = Rule("selector")
        rule.`margin-bottom`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-bottom", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-left`() {
        val rule = Rule("selector")
        rule.`margin-left`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-left", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }
}