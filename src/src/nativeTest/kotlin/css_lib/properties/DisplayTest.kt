package css_lib.properties

import css_lib.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class DisplayTest {
    @Test
    fun `test display`() {
        val rule = Rule("selector")
        rule.display(DisplayTypeValues.`inline-block`)

        assertEquals(1, rule.properties.size)
        assertEquals("display", rule.properties[0].property)
        assertEquals("inline-block", rule.properties[0].value)
    }
}
