package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextTransformTest {
    @Test
    fun `text-transform creates property`() {
        TextTransformTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`text-transform` = it
            assertEquals(1, rule.properties.size)
            assertEquals("text-transform", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `text-transform creates inherit property`() {
        val rule = Rule("selector")
        rule.`text-transform` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("text-transform", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `text-transform creates initial property`() {
        val rule = Rule("selector")
        rule.`text-transform` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("text-transform", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `text-transform creates none property`() {
        val rule = Rule("selector")
        rule.`text-transform` = none
        assertEquals(1, rule.properties.size)
        assertEquals("text-transform", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }
}
