package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexTest {
    @Test
    fun `test flex 1`() {
        val rule = Rule("selector")
        rule.flex(FlexSizeValue.initial, FlexSizeValue.initial, FlexBasisValue.initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial initial initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 2`() {
        val rule = Rule("selector")
        rule.flex(FlexSizeValue.initial, FlexSizeValue.initial, 1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial initial 1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex 3`() {
        val rule = Rule("selector")
        rule.flex(FlexSizeValue.initial, 1.0, FlexBasisValue.initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial 1.0 initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 4`() {
        val rule = Rule("selector")
        rule.flex(1.0, FlexSizeValue.initial, FlexBasisValue.initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("1.0 initial initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 5`() {
        val rule = Rule("selector")
        rule.flex(1.0, 1.0, FlexBasisValue.initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("1.0 1.0 initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 6`() {
        val rule = Rule("selector")
        rule.flex(FlexSizeValue.initial, 1.0, 1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial 1.0 1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex 7`() {
        val rule = Rule("selector")
        rule.flex(1.0, FlexSizeValue.initial, 1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("1.0 initial 1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex 8`() {
        val rule = Rule("selector")
        rule.flex(1.0, 1.0, 1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("1.0 1.0 1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex-basis`() {
        FlexBasisValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-basis`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("flex-basis", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test flex-basis value`() {
        val rule = Rule("selector")
        rule.`flex-basis`(1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-basis", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex-direction`() {
        FlexDirectionValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-direction`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("flex-direction", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test flex-grow`() {
        FlexSizeValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-grow`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("flex-grow", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test flex-grow value`() {
        val rule = Rule("selector")
        rule.`flex-grow`(1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-grow", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex-shrink`() {
        FlexSizeValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-shrink`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("flex-shrink", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test flex-shrink value`() {
        val rule = Rule("selector")
        rule.`flex-shrink`(1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-shrink", rule.properties[0].property)
        assertEquals("1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex-wrap`() {
        FlexWrapValue.entries.forEach {
            val rule = Rule("selector")
            rule.`flex-wrap`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("flex-wrap", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test flex-flow`() {
        FlexDirectionValue.entries.forEach { direction ->
            FlexWrapValue.entries.forEach { wrap ->
                val rule = Rule("selector")
                rule.`flex-flow`(direction, wrap)
                assertEquals(1, rule.properties.size)
                assertEquals("flex-flow", rule.properties[0].property)
                assertEquals("${direction.value} ${wrap.value}", rule.properties[0].value)
            }
        }
    }
}
