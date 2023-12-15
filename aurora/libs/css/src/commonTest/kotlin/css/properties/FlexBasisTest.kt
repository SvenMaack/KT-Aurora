package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexBasisTest {
    @Test
    fun `flex-basis creates property`() {
        FlexBasisTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-basis`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("flex-basis", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `flex-basis creates double property`() {
        val rule = Rule("selector")
        rule.`flex-basis` = 1.0
        assertEquals(1, rule.properties.size)
        assertEquals("flex-basis", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `flex-basis creates inherit property`() {
        val rule = Rule("selector")
        rule.`flex-basis`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-basis", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `flex-basis creates initial property`() {
        val rule = Rule("selector")
        rule.`flex-basis`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-basis", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
