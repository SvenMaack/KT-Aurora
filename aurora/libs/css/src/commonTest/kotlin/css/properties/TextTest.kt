package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TextTest {
    @Test
    fun `test text-transform`() {
        TextTransformValues.entries.forEach {
            val rule = Rule("selector")
            rule.`text-transform`(it)

            assertEquals(1, rule.properties.size)
            assertEquals("text-transform", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }
}
