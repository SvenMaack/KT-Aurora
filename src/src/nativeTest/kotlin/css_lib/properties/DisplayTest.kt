package css_lib.properties

import css_lib.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class DisplayTest {
    @Test
    fun `test display`() {
        DisplayTypeValues.entries.forEach {
            val rule = Rule("selector")
            rule.display(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, displayTypeValues: DisplayTypeValues) {
        assertEquals(1, rule.properties.size)
        assertEquals("display", rule.properties[0].property)
        assertEquals(displayTypeValues.value, rule.properties[0].value)
    }
}
