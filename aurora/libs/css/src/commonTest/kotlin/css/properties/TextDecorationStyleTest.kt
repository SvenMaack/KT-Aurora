package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextDecorationStyleTest {
    @Test
    fun `text-decoration-style creates property`() {
        TextDecorationStyleTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`text-decoration-style` = it
            assertEquals(1, rule.properties.size)
            assertEquals("text-decoration-style", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `text-decoration-style creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-decoration-style` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-style", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-decoration-style creates initial property`() {
        val rule = Rule("selector")
        rule.`text-decoration-style` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-style", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
