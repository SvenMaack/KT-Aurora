package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class MinWidthTest {
    @Test
    fun `min-width creates property`() {
        WidthTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`min-width` = it
            assertEquals(1, rule.properties.size)
            assertEquals("min-width", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `min-width creates initial property`() {
        val rule = Rule("selector")
        rule.`min-width` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("min-width", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `min-width creates inherit property`() {
        val rule = Rule("selector")
        rule.`min-width` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("min-width", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `min-width creates property with size values`() {
        val rule = Rule("selector")
        rule.`min-width` = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("min-width", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }
}
