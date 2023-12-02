package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class MarginTest {
    @Test
    fun `test margin`() {
        val rule = Rule("selector")
        rule.margin(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-2`() {
        val rule = Rule("selector")
        rule.margin(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-3`() {
        val rule = Rule("selector")
        rule.margin(auto, auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto auto auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-4`() {
        val rule = Rule("selector")
        rule.margin(auto, auto, auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto auto auto auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-top`() {
        val rule = Rule("selector")
        rule.`margin-top`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-top", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-top-value`() {
        val rule = Rule("selector")
        rule.`margin-top`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-top", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-right`() {
        val rule = Rule("selector")
        rule.`margin-right`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-right", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-right-value`() {
        val rule = Rule("selector")
        rule.`margin-right`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-right", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-bottom`() {
        val rule = Rule("selector")
        rule.`margin-bottom`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-bottom", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-bottom-value`() {
        val rule = Rule("selector")
        rule.`margin-bottom`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-bottom", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-left`() {
        val rule = Rule("selector")
        rule.`margin-left`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-left", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-left-value`() {
        val rule = Rule("selector")
        rule.`margin-left`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-left", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-block-start`() {
        val rule = Rule("selector")
        rule.`margin-block-start`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-start", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-block-start-value`() {
        val rule = Rule("selector")
        rule.`margin-block-start`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-start", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-block-end`() {
        val rule = Rule("selector")
        rule.`margin-block-end`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-end", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-block-end-value`() {
        val rule = Rule("selector")
        rule.`margin-block-end`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-end", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-block`() {
        val rule = Rule("selector")
        rule.`margin-block`(MarginValue.auto, MarginValue.auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }


    @Test
    fun `test margin-inline-start`() {
        val rule = Rule("selector")
        rule.`margin-inline-start`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-start", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-inline-start-value`() {
        val rule = Rule("selector")
        rule.`margin-inline-start`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-start", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-inline-end`() {
        val rule = Rule("selector")
        rule.`margin-inline-end`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-end", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test margin-inline-end-value`() {
        val rule = Rule("selector")
        rule.`margin-inline-end`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-end", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test margin-inline`() {
        val rule = Rule("selector")
        rule.`margin-inline`(MarginValue.auto, MarginValue.auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }
}
