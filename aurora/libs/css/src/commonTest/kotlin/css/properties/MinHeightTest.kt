package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class MinHeightTest {
    @Test
    fun `min-height creates property`() {
        HeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`min-height` = it
            assertEquals(1, rule.properties.size)
            assertEquals("min-height", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `min-height creates initial property`() {
        val rule = Rule("selector")
        rule.`min-height` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("min-height", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `min-height creates inherit property`() {
        val rule = Rule("selector")
        rule.`min-height` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("min-height", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `min-height creates property with size values`() {
        val rule = Rule("selector")
        rule.`min-height` = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("min-height", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }
}
