@file:Suppress("DEPRECATION")
package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class BackgroundColorTest {
    @Test
    fun `background-color creates property`() {
        ColorTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`background-color` = it
            assertEquals(1, rule.properties.size)
            assertEquals("background-color", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `background-color creates hex property`() {
        val rule = Rule("selector")
        rule.`background-color` = HexValue("#AABBCC")
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `background-color creates hex property with several values`() {
        val rule = Rule("selector")
        rule.`background-color` = HexValue("AA", "BB", "CC")
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("#AABBCC", rule.properties[0].value)
    }

    @Test
    fun `background-color creates rgb property`() {
        val rule = Rule("selector")
        rule.`background-color` = RGBValue("11", "22", "33")
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("rgb(11,22,33)", rule.properties[0].value)
    }

    @Test
    fun `background-color creates rgba property`() {
        val rule = Rule("selector")
        rule.`background-color` = RGBAValue("11", "22", "33", "13")
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("rgba(11,22,33,13)", rule.properties[0].value)
    }

    @Test
    fun `background-color creates hsl property`() {
        val rule = Rule("selector")
        rule.`background-color` = HSLValue(120, 100, 50)
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("hsl(120,100%,50%)", rule.properties[0].value)
    }

    @Test
    fun `background-color creates hsla property`() {
        val rule = Rule("selector")
        rule.`background-color` = HSLAValue(120, 100, 50, 0.3)
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("hsla(120,100%,50%,0.3)", rule.properties[0].value)
    }

    @Test
    fun `background-color creates inherit property`() {
        val rule = Rule("selector")
        rule.`background-color` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `background- color creates initial property`() {
        val rule = Rule("selector")
        rule.`background-color` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("background-color", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
