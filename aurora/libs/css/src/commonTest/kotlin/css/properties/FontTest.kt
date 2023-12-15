package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontTest {
    @Test
    fun `font creates property`() {
        FontTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.font = it
            assertEquals(1, rule.properties.size)
            assertEquals("font", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `font creates initial property`() {
        val rule = Rule("selector")
        rule.font = initial
        assertEquals(1, rule.properties.size)
        assertEquals("font", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `font creates inherit property`() {
        val rule = Rule("selector")
        rule.font = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("font", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `font creates property with all values`() {
        val rule = Rule("selector")
        rule.font()
        assertEquals(1, rule.properties.size)
        assertEquals("font", rule.properties[0].property)
        assertEquals("normal normal normal medium/normal inherit", rule.properties[0].value)
    }
}
