package css_lib.properties

import css_lib.base.Rule
import css_lib.properties.*
import kotlin.test.Test
import kotlin.test.assertEquals

class PaddingTest {
    @Test
    fun `test padding`() {
        val rule = Rule("selector")
        rule.padding(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-top`() {
        val rule = Rule("selector")
        rule.`padding-top`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-top", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-right`() {
        val rule = Rule("selector")
        rule.`padding-right`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-right", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-bottom`() {
        val rule = Rule("selector")
        rule.`padding-bottom`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-bottom", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-left`() {
        val rule = Rule("selector")
        rule.`padding-left`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-left", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }
}