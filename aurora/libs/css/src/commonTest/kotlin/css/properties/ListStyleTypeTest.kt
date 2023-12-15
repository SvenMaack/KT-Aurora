package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ListStyleTypeTest {
    @Test
    fun `list-style-type creates property`() {
        ListStyleTypeTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`list-style-type` = it
            assertEquals(1, rule.properties.size)
            assertEquals("list-style-type", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `list-style-type creates initial property`() {
        val rule = Rule("selector")
        rule.`list-style-type` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-type", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `list-style-type creates inherit property`() {
        val rule = Rule("selector")
        rule.`list-style-type` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-type", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }
}
