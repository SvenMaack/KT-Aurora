package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class OpacityTest {
    @Test
    fun `opacity creates property`() {
        val rule = Rule("selector")
        rule.opacity = 0.5
        assertEquals(1, rule.properties.size)
        assertEquals("opacity", rule.properties[0].property)
        assertEquals("0.5", rule.properties[0].value)
    }

    @Test
    fun `opacity creates inherit property`() {
        val rule = Rule("selector")
        rule.opacity(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("opacity", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `opacity creates initial property`() {
        val rule = Rule("selector")
        rule.opacity(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("opacity", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
