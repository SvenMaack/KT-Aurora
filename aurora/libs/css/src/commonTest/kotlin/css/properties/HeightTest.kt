package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class HeightTest {
    @Test
    fun height() {
        HeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.height(it)
            check(rule, "height", it)
        }
    }

    @Test
    fun `height value`() {
        val rule = Rule("selector")
        rule.height(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("height", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `min-height`() {
        HeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`min-height`(it)
            check(rule, "min-height", it)
        }
    }

    @Test
    fun `min-height value`() {
        val rule = Rule("selector")
        rule.`min-height`(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("min-height", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `max-height`() {
        HeightTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`max-height`(it)
            check(rule, "max-height", it)
        }
    }

    @Test
    fun `max-height value`() {
        val rule = Rule("selector")
        rule.`max-height`(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("max-height", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    private fun check(rule: Rule, property: String, entries: HeightTextValue) {
        assertEquals(1, rule.properties.size)
        assertEquals(property, rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
