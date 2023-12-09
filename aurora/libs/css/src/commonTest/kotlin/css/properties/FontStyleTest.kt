package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontStyleTest {
    @Test
    fun `test font-style`() {
        FontStyleValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-style`(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, entries: FontStyleValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("font-style", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
