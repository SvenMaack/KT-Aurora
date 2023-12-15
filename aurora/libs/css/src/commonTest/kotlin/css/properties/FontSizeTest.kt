package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontSizeTest {
    @Test
    fun `font-size creates property`() {
        val rule = Rule("selector")
        rule.`font-size` = 1.px
        assertEquals(1, rule.properties.size)
        assertEquals("font-size", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `font-size creates initial property`() {
        val rule = Rule("selector")
        rule.`font-size`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("font-size", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `font-size creates inherit property`() {
        val rule = Rule("selector")
        rule.`font-size`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("font-size", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `font-size creates text based property`() {
        FontSizeTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`font-size`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("font-size", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }
}
