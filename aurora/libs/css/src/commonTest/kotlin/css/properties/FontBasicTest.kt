package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontBasicTest {
    @Test
    fun `test font`() {
        FontValue.entries.forEach {
            val rule = Rule("selector")
            rule.font(it)
            check(rule, it)
        }
    }

    @Test
    fun `test font value`() {
        val rule = Rule("selector")
        rule.font()
        assertEquals(1, rule.properties.size)
        assertEquals("font", rule.properties[0].property)
        assertEquals("normal normal normal medium/normal inherit", rule.properties[0].value)
    }

    private fun check(rule: Rule, entries: FontValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("font", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
