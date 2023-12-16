package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextDecorationTest {
    @Test
    fun `text-decoration creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-decoration` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-decoration creates initial property`() {
        val rule = Rule("selector")
        rule.`text-decoration` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `text-decoration creates none property`() {
        val rule = Rule("selector")
        rule.`text-decoration` = none
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }

    @Test
    fun `text-decoration creates complete property`() {
        val rule = Rule("selector")
        rule.`text-decoration`(initial, initial, initial, initial)
        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration", rule.properties[0].property)
        assertEquals("initial initial initial initial", rule.properties[0].value)
    }
}
