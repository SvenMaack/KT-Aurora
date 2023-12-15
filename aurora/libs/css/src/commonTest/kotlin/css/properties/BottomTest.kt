package css.properties

import css.base.BeforeAfterRule
import kotlin.test.Test
import kotlin.test.assertEquals

class BottomTest {
    @Test
    fun `bottom creates property`() {
        PositionDistanceTextValue.entries.forEach {
            val rule = BeforeAfterRule("selector")
            rule.bottom(it)
            assertEquals(1, rule.properties.size)
            assertEquals("bottom", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `bottom creates number property`() {
        val rule = BeforeAfterRule("selector")
        rule.bottom = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("bottom", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `bottom creates inherit property`() {
        val rule = BeforeAfterRule("selector")
        rule.bottom(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("bottom", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `bottom creates initial property`() {
        val rule = BeforeAfterRule("selector")
        rule.bottom(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("bottom", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
