package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontWeightTest {
    @Test
    fun `font-weight creates initial property`() {
        val rule = Rule("selector")
        rule.`font-weight` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("font-weight", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `font-weight creates inherit property`() {
        val rule = Rule("selector")
        rule.`font-weight` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("font-weight", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `font-weight creates text based property`() {
        FontWeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-weight` = it
            assertEquals(1, rule.properties.size)
            assertEquals("font-weight", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }
}
