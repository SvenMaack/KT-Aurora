package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextTest {
    @Test
    fun `text-transform`() {
        TextTransformValues.entries.forEach {
            val rule = Rule("selector")
            rule.`text-transform`(it)

            assertEquals(1, rule.properties.size)
            assertEquals("text-transform", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `text-rendering`() {
        TextRenderingValues.entries.forEach {
            val rule = Rule("selector")
            rule.`text-rendering`(it)

            assertEquals(1, rule.properties.size)
            assertEquals("text-rendering", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `line-height`() {
        LineHeightValue.entries.forEach {
            val rule = Rule("selector")
            rule.`line-height`(it)

            assertEquals(1, rule.properties.size)
            assertEquals("line-height", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `line-height value`() {
        val rule = Rule("selector")
        rule.`line-height`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("line-height", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `line-height number`() {
        val rule = Rule("selector")
        rule.`line-height`(5.0)

        assertEquals(1, rule.properties.size)
        assertEquals("line-height", rule.properties[0].property)
        assertEquals("5.0", rule.properties[0].value)
    }
}
