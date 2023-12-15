package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class LineHeightTest {
    @Test
    fun `line-height creates property`() {
        LineHeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`line-height`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("line-height", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `line-height creates size property`() {
        val rule = Rule("selector")
        rule.`line-height`(1.px)
        assertEquals(1, rule.properties.size)
        assertEquals("line-height", rule.properties[0].property)
        assertEquals("1px", rule.properties[0].value)
    }

    @Test
    fun `line-height creates number property`() {
        val rule = Rule("selector")
        rule.`line-height` = 1.0
        assertEquals(1, rule.properties.size)
        assertEquals("line-height", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `line-height creates inherit property`() {
        val rule = Rule("selector")
        rule.`line-height`(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("line-height", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `line-height creates initial property`() {
        val rule = Rule("selector")
        rule.`line-height`(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("line-height", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
