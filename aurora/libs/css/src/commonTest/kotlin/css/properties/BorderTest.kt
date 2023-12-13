package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class BorderTest {
    @Test
    fun `test border-radius 1`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `test border-radius 2`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px, 2.rem)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px 2rem", rule.properties[0].value)
    }

    @Test
    fun `test border-radius 3`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px, 2.rem, 3.px)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px 2rem 3px", rule.properties[0].value)
    }

    @Test
    fun `test border-radius 4`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px, 2.rem, 3.px, 4.px)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px 2rem 3px 4px", rule.properties[0].value)
    }
}
