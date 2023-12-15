package css.properties

import css.base.BeforeAfterRule
import kotlin.test.Test
import kotlin.test.assertEquals

class RightTest {
    @Test
    fun `right creates property`() {
        PositionDistanceTextValue.entries.forEach {
            val rule = BeforeAfterRule("selector")
            rule.right(it)
            assertEquals(1, rule.properties.size)
            assertEquals("right", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `right creates number property`() {
        val rule = BeforeAfterRule("selector")
        rule.right = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("right", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `right creates inherit property`() {
        val rule = BeforeAfterRule("selector")
        rule.right(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("right", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `right creates initial property`() {
        val rule = BeforeAfterRule("selector")
        rule.right(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("right", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
