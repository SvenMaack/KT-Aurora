package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class CursorTest {
    @Test
    fun `cursor creates property`() {
        CursorTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.cursor = it
            assertEquals(1, rule.properties.size)
            assertEquals("cursor", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `cursor creates inherit property`() {
        val rule = Rule("selector")
        rule.cursor = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("cursor", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `cursor creates initial property`() {
        val rule = Rule("selector")
        rule.cursor = initial
        assertEquals(1, rule.properties.size)
        assertEquals("cursor", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
