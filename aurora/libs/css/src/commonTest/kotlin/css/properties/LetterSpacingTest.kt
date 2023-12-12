package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class LetterSpacingTest {
    @Test
    fun `test letter-spacing`() {
        LetterSpacingTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`letter-spacing`(it)
            assertEquals(1, rule.properties.size)
            assertEquals("letter-spacing", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `test letter-spacing value`() {
        val rule = Rule("selector")
        rule.`letter-spacing`(5.px)
        assertEquals(1, rule.properties.size)
        assertEquals("letter-spacing", rule.properties[0].property)
        assertEquals("5px", rule.properties[0].value)
    }
}
