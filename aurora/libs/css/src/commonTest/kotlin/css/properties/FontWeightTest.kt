package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontWeightTest {
    @Test
    fun `test font-weight`() {
        FontWeightValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-weight`(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, entries: FontWeightValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("font-weight", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
