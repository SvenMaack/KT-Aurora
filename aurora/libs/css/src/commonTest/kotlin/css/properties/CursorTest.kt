package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class CursorTest {
    @Test
    fun `test cursor`() {
        CursorValue.entries.forEach {
            val rule = Rule("selector")
            rule.cursor(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, entries: CursorValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("cursor", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
