@file:Suppress("DEPRECATION")
package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun `test color`() {
        ColorTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.color(it)
            assertEquals(1, rule.properties.size)
            assertEquals("color", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test color hex 1`() {
        val rule = Rule("selector")
        rule.color(HexValue("#AABBCC"))
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `test color hex 2`() {
        val rule = Rule("selector")
        rule.color(HexValue("AA", "BB", "CC"))
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `test color rgb`() {
        val rule = Rule("selector")
        rule.color(RGBValue("11", "22", "33"))
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("rgb(11,22,33)", rule.properties[0].value)
    }

    @Test
    fun `test color rgba`() {
        val rule = Rule("selector")
        rule.color(RGBAValue("11", "22", "33", "13"))
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("rgba(11,22,33,13)", rule.properties[0].value)
    }

    @Test
    fun `test color hsl`() {
        val rule = Rule("selector")
        rule.color(HSLValue(120, 100, 50))
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("hsl(120,100%,50%)", rule.properties[0].value)
    }

    @Test
    fun `test color hsla`() {
        val rule = Rule("selector")
        rule.color(HSLAValue(120, 100, 50, 0.3))
        assertEquals(1, rule.properties.size)
        assertEquals("color", rule.properties[0].property)
        assertEquals("hsla(120,100%,50%,0.3)", rule.properties[0].value)
    }







    @Test
    fun `test background-color`() {
        ColorTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`background-color`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("background-color", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test background-color hex 1`() {
        val rule = Rule("selector")
        rule.`background-color`(HexValue("#AABBCC"))
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `test background-color hex 2`() {
        val rule = Rule("selector")
        rule.`background-color`(HexValue("AA", "BB", "CC"))
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `test background-color rgb`() {
        val rule = Rule("selector")
        rule.`background-color`(RGBValue("11", "22", "33"))
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("rgb(11,22,33)", rule.properties[0].value)
    }

    @Test
    fun `test background-color rgba`() {
        val rule = Rule("selector")
        rule.`background-color`(RGBAValue("11", "22", "33", "13"))
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("rgba(11,22,33,13)", rule.properties[0].value)
    }

    @Test
    fun `test background-color hsl`() {
        val rule = Rule("selector")
        rule.`background-color`(HSLValue(120, 100, 50))
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("hsl(120,100%,50%)", rule.properties[0].value)
    }

    @Test
    fun `test background-color hsla`() {
        val rule = Rule("selector")
        rule.`background-color`(HSLAValue(120, 100, 50, 0.3))
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("hsla(120,100%,50%,0.3)", rule.properties[0].value)
    }
}
