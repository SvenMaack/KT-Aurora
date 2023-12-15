package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexGrowTest {
    @Test
    fun `flex-grow creates double property`() {
        val rule = Rule("selector")
        rule.`flex-grow` = 1.0
        assertEquals(1, rule.properties.size)
        assertEquals("flex-grow", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `flex-grow creates inherit property`() {
        val rule = Rule("selector")
        rule.`flex-grow`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-grow", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `flex-grow creates initial property`() {
        val rule = Rule("selector")
        rule.`flex-grow`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-grow", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
