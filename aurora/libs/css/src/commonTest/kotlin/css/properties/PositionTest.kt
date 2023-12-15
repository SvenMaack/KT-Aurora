package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class PositionTest {
    @Test
    fun `position creates property`() {
        PositionTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.position = it
            assertEquals(1, rule.properties.size)
            assertEquals("position", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }
}
