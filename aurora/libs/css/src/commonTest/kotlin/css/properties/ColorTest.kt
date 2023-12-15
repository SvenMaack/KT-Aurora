@file:Suppress("DEPRECATION")
package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun `color creates property`() {
        ColorTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.color = it
            assertEquals(1, rule.properties.size)
            assertEquals("color", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `color creates hex property`() {
        val rule = Rule("selector")
        rule.color = HexValue("#AABBCC")
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `color creates hex property with several values`() {
        val rule = Rule("selector")
        rule.color = HexValue("AA", "BB", "CC")
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `color creates rgb property`() {
        val rule = Rule("selector")
        rule.color = RGBValue("11", "22", "33")
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("rgb(11,22,33)", rule.properties[0].value)
    }

    @Test
    fun `color creates rgba property`() {
        val rule = Rule("selector")
        rule.color = RGBAValue("11", "22", "33", "13")
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("rgba(11,22,33,13)", rule.properties[0].value)
    }

    @Test
    fun `color creates hsl property`() {
        val rule = Rule("selector")
        rule.color = HSLValue(120, 100, 50)
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("hsl(120,100%,50%)", rule.properties[0].value)
    }

    @Test
    fun `color creates hsla property`() {
        val rule = Rule("selector")
        rule.color = HSLAValue(120, 100, 50, 0.3)
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("hsla(120,100%,50%,0.3)", rule.properties[0].value)
    }

    @Test
    fun `color creates inherit property`() {
        val rule = Rule("selector")
        rule.color = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `color creates initial property`() {
        val rule = Rule("selector")
        rule.color = initial
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
