package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class WidthTest {
    @Test
    fun `width creates property`() {
        WidthTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.width = it
            assertEquals(1, rule.properties.size)
            assertEquals("width", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `width creates initial property`() {
        val rule = Rule("selector")
        rule.width = initial
        assertEquals(1, rule.properties.size)
        assertEquals("width", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `width creates inherit property`() {
        val rule = Rule("selector")
        rule.width = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("width", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `width creates property with size values`() {
        val rule = Rule("selector")
        rule.width = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("width", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }
}
