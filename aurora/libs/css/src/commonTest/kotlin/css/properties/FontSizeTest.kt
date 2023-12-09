package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontSizeTest {
    @Test
    fun `test font-size`() {
        FontSizeValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-size`(it)
            check(rule, it)
        }
    }

    @Test
    fun `test font-size value`() {
        val rule = Rule("selector")
        rule.`font-size`(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("font-size", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    private fun check(rule: Rule, entries: FontSizeValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("font-size", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
