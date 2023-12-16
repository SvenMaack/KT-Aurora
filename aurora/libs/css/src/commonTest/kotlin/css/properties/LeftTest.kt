package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class LeftTest {
    @Test
    fun `left creates property`() {
        PositionDistanceTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.left(it)
            assertEquals(1, rule.properties.size)
            assertEquals("left", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `left creates number property`() {
        val rule = Rule("selector")
        rule.left = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("left", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `left creates inherit property`() {
        val rule = Rule("selector")
        rule.left(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("left", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `left creates initial property`() {
        val rule = Rule("selector")
        rule.left(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("left", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
