package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontVariantTest {
    @Test
    fun `test font-variant`() {
        FontVariantValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-variant`(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, entries: FontVariantValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("font-variant", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
