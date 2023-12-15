package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class MaxWidthTest {
    @Test
    fun `max-width creates property`() {
        WidthTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`max-width` = it
            assertEquals(1, rule.properties.size)
            assertEquals("max-width", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `max-width creates initial property`() {
        val rule = Rule("selector")
        rule.`max-width` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("max-width", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `max-width creates inherit property`() {
        val rule = Rule("selector")
        rule.`max-width` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("max-width", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `max-width creates property with size values`() {
        val rule = Rule("selector")
        rule.`max-width` = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("max-width", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }
}
