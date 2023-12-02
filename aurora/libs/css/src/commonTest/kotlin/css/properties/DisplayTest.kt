package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class DisplayTest {
    @Test
    fun `test display`() {
        DisplayTypeValue.entries.forEach {
            val rule = Rule("selector")
            rule.display(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, displayTypeValue: DisplayTypeValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("display", rule.properties[0].property)
        assertEquals(displayTypeValue.value, rule.properties[0].value)
    }
}
