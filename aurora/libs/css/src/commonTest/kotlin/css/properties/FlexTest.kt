package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexTest {
    @Test
    fun `flex creates property 1`() {
        val rule = Rule("selector")
        rule.flex(initial, initial, initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial initial initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 2`() {
        val rule = Rule("selector")
        rule.flex(initial, initial, 1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial initial 1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex 3`() {
        val rule = Rule("selector")
        rule.flex(initial, 1.0, initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial 1.0 initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 4`() {
        val rule = Rule("selector")
        rule.flex(1.0, initial, initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("1.0 initial initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 5`() {
        val rule = Rule("selector")
        rule.flex(1.0, 1.0, initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("1.0 1.0 initial", rule.properties[0].value)
    }

    @Test
    fun `test flex 6`() {
        val rule = Rule("selector")
        rule.flex(initial, 1.0, 1.0)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial 1.0 1.0", rule.properties[0].value)
    }

    @Test
    fun `test flex 7`() {
        val rule = Rule("selector")
        rule.flex(1.0, initial, 1.0)
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
    fun `flex creates initial property`() {
        val rule = Rule("selector")
        rule.flex(initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `flex creates inherit property`() {
        val rule = Rule("selector")
        rule.flex(inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `flex creates initial none property`() {
        val rule = Rule("selector")
        rule.flex(none)
        assertEquals(1, rule.properties.size)
        assertEquals("flex", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }
}
