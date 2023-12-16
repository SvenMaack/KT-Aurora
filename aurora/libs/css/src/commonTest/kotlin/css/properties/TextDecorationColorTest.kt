package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextDecorationColorTest {
    @Test
    fun `text-decoration-color creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-decoration-color`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-color", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-decoration-color creates initial property`() {
        val rule = Rule("selector")
        rule.`text-decoration-color`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-color", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `bottom creates number property`() {
        val rule = Rule("selector")
        rule.`text-decoration-color` = HSLValue(1, 2, 3)
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration-color", rule.properties[0].property)
        assertEquals("hsl(1,2%,3%)", rule.properties[0].value)
    }
}
