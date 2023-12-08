package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class BoxTest {
    @Test
    fun `test box-sizing`() {
        BoxSizingValue.entries.forEach {
            val rule = Rule("selector")
            rule.`box-sizing`(it)
            check(rule, it)
        }
        SpecialBoxSizingValue.entries.forEach {
            val rule = Rule("selector")
            rule.`box-sizing`(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, entries: BoxSizingValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("box-sizing", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }

    private fun check(rule: Rule, entries: SpecialBoxSizingValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("box-sizing", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
