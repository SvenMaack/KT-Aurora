package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ListStylePositionTest {
    @Test
    fun `list-style-position creates property`() {
        ListStylePositionTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`list-style-position` = it
            assertEquals(1, rule.properties.size)
            assertEquals("list-style-position", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `list-style-position creates initial property`() {
        val rule = Rule("selector")
        rule.`list-style-position` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-position", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `list-style-position creates inherit property`() {
        val rule = Rule("selector")
        rule.`list-style-position` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-position", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }
}
