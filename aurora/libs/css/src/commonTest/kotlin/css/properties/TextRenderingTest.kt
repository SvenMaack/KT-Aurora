package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextRenderingTest {
    @Test
    fun `text-rendering creates property`() {
        TextRenderingTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`text-rendering` = it
            assertEquals(1, rule.properties.size)
            assertEquals("text-rendering", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `text-rendering creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-rendering` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("text-rendering", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-rendering creates initial property`() {
        val rule = Rule("selector")
        rule.`text-rendering` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("text-rendering", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
