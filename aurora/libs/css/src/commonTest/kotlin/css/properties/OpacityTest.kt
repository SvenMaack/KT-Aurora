package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class OpacityTest {
    @Test
    fun opacity() {
        OpacityValue.entries.forEach {
            val rule = Rule("selector")
            rule.opacity(it)
            assertEquals(1, rule.properties.size)
            assertEquals("opacity", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `opacity value`() {
        val rule = Rule("selector")
        rule.opacity(0.5)
        assertEquals(1, rule.properties.size)
        assertEquals("opacity", rule.properties[0].property)
        assertEquals("0.5", rule.properties[0].value)
    }
}
