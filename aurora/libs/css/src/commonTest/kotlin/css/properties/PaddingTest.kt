@file:Suppress("DEPRECATION")

package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals
import css.properties.PaddingTextValue.auto

class PaddingTest {
    @Test
    fun `test padding`() {
        val rule = Rule("selector")
        rule.padding(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-2`() {
        val rule = Rule("selector")
        rule.padding(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-3`() {
        val rule = Rule("selector")
        rule.padding(auto, auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding", rule.properties[0].property)
        assertEquals("auto auto auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-4`() {
        val rule = Rule("selector")
        rule.padding(auto, auto, auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding", rule.properties[0].property)
        assertEquals("auto auto auto auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-top`() {
        val rule = Rule("selector")
        rule.`padding-top`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-top", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-top-value`() {
        val rule = Rule("selector")
        rule.`padding-top`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-top", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-right`() {
        val rule = Rule("selector")
        rule.`padding-right`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-right", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-right-value`() {
        val rule = Rule("selector")
        rule.`padding-right`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-right", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-bottom`() {
        val rule = Rule("selector")
        rule.`padding-bottom`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-bottom", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-bottom-value`() {
        val rule = Rule("selector")
        rule.`padding-bottom`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-bottom", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-left`() {
        val rule = Rule("selector")
        rule.`padding-left`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-left", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-left-value`() {
        val rule = Rule("selector")
        rule.`padding-left`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-left", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-block-start`() {
        val rule = Rule("selector")
        rule.`padding-block-start`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-block-start", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-block-start-value`() {
        val rule = Rule("selector")
        rule.`padding-block-start`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-block-start", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-block-end`() {
        val rule = Rule("selector")
        rule.`padding-block-end`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-block-end", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-block-end-value`() {
        val rule = Rule("selector")
        rule.`padding-block-end`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-block-end", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-block`() {
        val rule = Rule("selector")
        rule.`padding-block`(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-block", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }


    @Test
    fun `test padding-inline-start`() {
        val rule = Rule("selector")
        rule.`padding-inline-start`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-inline-start", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-inline-start-value`() {
        val rule = Rule("selector")
        rule.`padding-inline-start`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-inline-start", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-inline-end`() {
        val rule = Rule("selector")
        rule.`padding-inline-end`(auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-inline-end", rule.properties[0].property)
        assertEquals("auto", rule.properties[0].value)
    }

    @Test
    fun `test padding-inline-end-value`() {
        val rule = Rule("selector")
        rule.`padding-inline-end`(5.px)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-inline-end", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }

    @Test
    fun `test padding-inline`() {
        val rule = Rule("selector")
        rule.`padding-inline`(auto, auto)

        assertEquals(1, rule.properties.size)
        assertEquals("padding-inline", rule.properties[0].property)
        assertEquals("auto auto", rule.properties[0].value)
    }
}
