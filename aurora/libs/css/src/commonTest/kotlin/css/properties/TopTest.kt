package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TopTest {
    @Test
    fun `top creates property`() {
        PositionDistanceTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.top(it)
            assertEquals(1, rule.properties.size)
            assertEquals("top", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `top creates number property`() {
        val rule = Rule("selector")
        rule.top = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("top", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `top creates inherit property`() {
        val rule = Rule("selector")
        rule.top(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("top", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `top creates initial property`() {
        val rule = Rule("selector")
        rule.top(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("top", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
