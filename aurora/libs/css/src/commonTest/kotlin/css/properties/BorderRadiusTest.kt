package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class BorderRadiusTest {
    @Test
    fun `border-radius creates property`() {
        val rule = Rule("selector")
        rule.`border-radius` = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `border-radius creates inherit property`() {
        val rule = Rule("selector")
        rule.`border-radius` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `border-radius creates initial property`() {
        val rule = Rule("selector")
        rule.`border-radius` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `border-radius creates property with 2 values`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px, 2.rem)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px 2rem", rule.properties[0].value)
    }

    @Test
    fun `border-radius creates property with 3 values`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px, 2.rem, 3.px)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px 2rem 3px", rule.properties[0].value)
    }

    @Test
    fun `border-radius creates property with 4 values`() {
        val rule = Rule("selector")
        rule.`border-radius`(1.px, 2.rem, 3.px, 4.px)
        assertEquals(1, rule.properties.size)
        assertEquals("border-radius", rule.properties[0].property)
        assertEquals("1px 2rem 3px 4px", rule.properties[0].value)
    }
}
