package css_lib.properties

import css_lib.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextTest {
    @Test
    fun `test text-decoration`() {
        val rule = Rule("selector")
        rule.`text-decoration`(TextDecorationValues.none)

        assertEquals(1, rule.properties.size)
        assertEquals("text-decoration", rule.properties[0].property)
        assertEquals("none", rule.properties[0].value)
    }

    @Test
    fun `test text-transform`() {
        val rule = Rule("selector")
        rule.`text-transform`(TextTransformValues.uppercase)

        assertEquals(1, rule.properties.size)
        assertEquals("text-transform", rule.properties[0].property)
        assertEquals("uppercase", rule.properties[0].value)
    }
}
