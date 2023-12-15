package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontStyleTest {
    @Test
    fun `font-style creates initial property`() {
        val rule = Rule("selector")
        rule.`font-style` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("font-style", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `font-style creates inherit property`() {
        val rule = Rule("selector")
        rule.`font-style` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("font-style", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `font-style creates text based property`() {
        FontStyleTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-style` = it
            assertEquals(1, rule.properties.size)
            assertEquals("font-style", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }
}
