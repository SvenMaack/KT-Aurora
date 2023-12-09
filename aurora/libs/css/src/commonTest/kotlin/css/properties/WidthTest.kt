package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class WidthTest {
    @Test
    fun width() {
        WidthTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.width(it)
            check(rule, "width", it)
        }
    }

    @Test
    fun `width value`() {
        val rule = Rule("selector")
        rule.width(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("width", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `min-width`() {
        WidthTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`min-width`(it)
            check(rule, "min-width", it)
        }
    }

    @Test
    fun `min-width value`() {
        val rule = Rule("selector")
        rule.`min-width`(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("min-width", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `max-width`() {
        WidthTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`max-width`(it)
            check(rule, "max-width", it)
        }
    }

    @Test
    fun `max-width value`() {
        val rule = Rule("selector")
        rule.`max-width`(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("max-width", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    private fun check(rule: Rule, property: String, entries: WidthTextValue) {
        assertEquals(1, rule.properties.size)
        assertEquals(property, rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
