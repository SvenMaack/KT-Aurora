package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontFamilyTest {
    @Test
    fun `test font-family`() {
        FontFamilyValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-family`(it)
            check(rule, it)
        }
    }

    @Test
    fun `test font-size value`() {
        val rule = Rule("selector")
        rule.`font-family`("test")
        assertEquals(1, rule.properties.size)
        assertEquals("font-family", rule.properties[0].property)
        assertEquals("test", rule.properties[0].value)
    }

    private fun check(rule: Rule, entries: FontFamilyValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("font-family", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
