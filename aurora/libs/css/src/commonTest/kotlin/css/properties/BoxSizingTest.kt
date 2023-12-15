package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class BoxSizingTest {
    @Test
    fun `box-sizing creates property`() {
        BoxSizingTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`box-sizing` = it
            assertEquals(1, rule.properties.size)
            assertEquals("box-sizing", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `box-sizing creates initial property`() {
        val rule = Rule("selector")
        rule.`box-sizing` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("box-sizing", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `box-sizing creates inherit property`() {
        val rule = Rule("selector")
        rule.`box-sizing` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("box-sizing", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }
}
