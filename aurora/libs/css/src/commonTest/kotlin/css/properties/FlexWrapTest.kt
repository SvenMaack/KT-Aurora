package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexWrapTest {
    @Test
    fun `flex-wrap creates property`() {
        FlexWrapTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-wrap` = it
            assertEquals(1, rule.properties.size)
            assertEquals("flex-wrap", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `flex-wrap creates inherit property`() {
        val rule = Rule("selector")
        rule.`flex-wrap` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("flex-wrap", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `flex-wrap creates initial property`() {
        val rule = Rule("selector")
        rule.`flex-wrap` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("flex-wrap", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
