package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class DisplayTest {
    @Test
    fun `display creates property`() {
        DisplayTypeTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.display = it
            assertEquals(1, rule.properties.size)
            assertEquals("display", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `display creates initial property`() {
        val rule = Rule("selector")
        rule.display = initial
        assertEquals(1, rule.properties.size)
        assertEquals("display", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `display creates inherit property`() {
        val rule = Rule("selector")
        rule.display = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("display", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `display creates none property`() {
        val rule = Rule("selector")
        rule.display = none
        assertEquals(1, rule.properties.size)
        assertEquals("display", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }
}
