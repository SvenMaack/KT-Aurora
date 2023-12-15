package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontVariantTest {
    @Test
    fun `font-variant creates initial property`() {
        val rule = Rule("selector")
        rule.`font-variant` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("font-variant", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `font-variant creates inherit property`() {
        val rule = Rule("selector")
        rule.`font-variant` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("font-variant", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `font-variant creates text based property`() {
        FontVariantTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-variant` = it
            assertEquals(1, rule.properties.size)
            assertEquals("font-variant", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }
}
