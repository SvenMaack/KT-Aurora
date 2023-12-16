package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextDecorationThicknessTest {
    @Test
    fun `text-decoration-thickness creates property`() {
        TextDecorationThicknessTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`text-decoration-thickness` = it
            assertEquals(1, rule.properties.size)
            assertEquals("text-decoration-thickness", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `text-decoration-thickness creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-decoration-thickness` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-thickness", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-decoration-thickness creates initial property`() {
        val rule = Rule("selector")
        rule.`text-decoration-thickness` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-thickness", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `text-decoration-thickness creates size property`() {
        val rule = Rule("selector")
        rule.`text-decoration-thickness` = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-thickness", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }
}
