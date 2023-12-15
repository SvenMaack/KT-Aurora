@file:Suppress("DEPRECATION")

package css.properties

import css.base.Rule
import css.properties.MarginTextValue.auto
import kotlin.test.Test
import kotlin.test.assertEquals

class MarginTest {
    @Test
    fun margin() {
        val rule = Rule("selector")
        rule.margin = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-2`() {
        val rule = Rule("selector")
        rule.margin(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }

    @Test
    fun `margin-3`() {
        val rule = Rule("selector")
        rule.margin(auto, auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto auto auto", rule.properties[0].value)
    }

    @Test
    fun `margin-4`() {
        val rule = Rule("selector")
        rule.margin(auto, auto, auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin", rule.properties[0].property)
        assertEquals("auto auto auto auto", rule.properties[0].value)
    }

    @Test
    fun `margin-top`() {
        val rule = Rule("selector")
        rule.`margin-top` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-top", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-top-value`() {
        val rule = Rule("selector")
        rule.`margin-top` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-top", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-right`() {
        val rule = Rule("selector")
        rule.`margin-right` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-right", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-right-value`() {
        val rule = Rule("selector")
        rule.`margin-right` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-right", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-bottom`() {
        val rule = Rule("selector")
        rule.`margin-bottom` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-bottom", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-bottom-value`() {
        val rule = Rule("selector")
        rule.`margin-bottom` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-bottom", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-left`() {
        val rule = Rule("selector")
        rule.`margin-left` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-left", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-left-value`() {
        val rule = Rule("selector")
        rule.`margin-left` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-left", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-block-start`() {
        val rule = Rule("selector")
        rule.`margin-block-start` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-start", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-block-start-value`() {
        val rule = Rule("selector")
        rule.`margin-block-start` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-start", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-block-end`() {
        val rule = Rule("selector")
        rule.`margin-block-end` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-end", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-block-end-value`() {
        val rule = Rule("selector")
        rule.`margin-block-end` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block-end", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-block 2`() {
        val rule = Rule("selector")
        rule.`margin-block`(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }

    @Test
    fun `margin-block`() {
        val rule = Rule("selector")
        rule.`margin-block` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-block", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }


    @Test
    fun `margin-inline-start`() {
        val rule = Rule("selector")
        rule.`margin-inline-start` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-start", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-inline-start-value`() {
        val rule = Rule("selector")
        rule.`margin-inline-start` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-start", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-inline-end`() {
        val rule = Rule("selector")
        rule.`margin-inline-end` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-end", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `margin-inline-end-value`() {
        val rule = Rule("selector")
        rule.`margin-inline-end` = 5.px

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline-end", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `margin-inline 2`() {
        val rule = Rule("selector")
        rule.`margin-inline`(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }

    @Test
    fun `margin-inline`() {
        val rule = Rule("selector")
        rule.`margin-inline` = auto

        assertEquals(1, rule.properties.size)
        assertEquals("margin-inline", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }
}
