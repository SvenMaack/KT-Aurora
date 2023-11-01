package css_lib.properties

import css_lib.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformTest {
    @Test
    fun `test transform`() {
        val rule = Rule("selector")
        rule.transform(-50.percentage, 50.percentage)

        assertEquals(2, rule.properties.size)
        assertEquals("-webkit-transform", rule.properties[0].property)
        assertEquals("transform", rule.properties[1].property)
        assertEquals("translate(-50%,50%)", rule.properties[0].value)
        assertEquals("translate(-50%,50%)", rule.properties[1].value)
    }
}
