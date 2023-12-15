package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class HeightTest {
    @Test
    fun `height creates property`() {
        HeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.height = it
            assertEquals(1, rule.properties.size)
            assertEquals("height", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `height creates initial property`() {
        val rule = Rule("selector")
        rule.height = initial
        assertEquals(1, rule.properties.size)
        assertEquals("height", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `height creates inherit property`() {
        val rule = Rule("selector")
        rule.height = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("height", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `height creates property with size values`() {
        val rule = Rule("selector")
        rule.height = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("height", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }
}
