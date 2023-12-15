package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class FlexFlowTest {
    @Test
    fun `flex-flow creates property`() {
        val rule = Rule("selector")
        rule.`flex-flow`(inherit, initial)
        assertEquals(1, rule.properties.size)
        assertEquals("flex-flow", rule.properties[0].property)
        assertEquals("inherit initial", rule.properties[0].value)
    }
}
