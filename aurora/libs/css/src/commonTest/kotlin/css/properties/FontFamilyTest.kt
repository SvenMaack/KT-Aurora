package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FontFamilyTest {
    @Test
    fun `font-family creates property`() {
        val rule = Rule("selector")
        rule.`font-family` = "test"
        assertEquals(1, rule.properties.size)
        assertEquals("font-family", rule.properties[0].property)
        assertEquals("test", rule.properties[0].value)
    }

    @Test
    fun `font-family creates initial property`() {
        val rule = Rule("selector")
        rule.`font-family`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("font-family", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `font-family creates inherit property`() {
        val rule = Rule("selector")
        rule.`font-family`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("font-family", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }
}
