package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextDecorationLineTest {
    @Test
    fun `text-decoration-line creates property`() {
        TextDecorationLineTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`text-decoration-line` = it
            assertEquals(1, rule.properties.size)
            assertEquals("text-decoration-line", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `text-decoration-line creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-decoration-line` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-line", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-decoration-line creates initial property`() {
        val rule = Rule("selector")
        rule.`text-decoration-line` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-line", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `text-decoration-line creates none property`() {
        val rule = Rule("selector")
        rule.`text-decoration-line` = none
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-line", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }
}
