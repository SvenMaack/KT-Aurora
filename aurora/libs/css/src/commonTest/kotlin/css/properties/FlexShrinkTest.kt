package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexShrinkTest {
    @Test
    fun `flex-shrink creates double property`() {
        val rule = Rule("selector")
        rule.`flex-shrink` = 1.0
        assertEquals(1, rule.properties.size)
        assertEquals("flex-shrink", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `flex-shrink creates inherit property`() {
        val rule = Rule("selector")
        rule.`flex-shrink`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-shrink", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `flex-shrink creates initial property`() {
        val rule = Rule("selector")
        rule.`flex-shrink`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-shrink", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
