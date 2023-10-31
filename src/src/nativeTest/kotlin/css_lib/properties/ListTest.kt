package css_lib.properties

import css_lib.base.Rule
import css_lib.properties.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ListTest {
    @Test
    fun `test list-style`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleValues.none)

        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }
}
