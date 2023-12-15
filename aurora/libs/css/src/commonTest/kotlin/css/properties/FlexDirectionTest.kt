package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexDirectionTest {
    @Test
    fun `flex-direction creates property`() {
        FlexDirectionTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-direction` = it
            assertEquals(1, rule.properties.size)
            assertEquals("flex-direction", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `flex-direction creates inherit property`() {
        val rule = Rule("selector")
        rule.`flex-direction` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("flex-direction", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `flex-direction creates initial property`() {
        val rule = Rule("selector")
        rule.`flex-direction` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("flex-direction", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
