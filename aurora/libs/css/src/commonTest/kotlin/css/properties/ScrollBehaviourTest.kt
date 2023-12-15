package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ScrollBehaviourTest {
    @Test
    fun `scroll-behavior creates property`() {
        ScrollBehaviourTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`scroll-behavior` = it
            assertEquals(1, rule.properties.size)
            assertEquals("scroll-behavior", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `scroll-behavior creates inherit property`() {
        val rule = Rule("selector")
        rule.`scroll-behavior` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("scroll-behavior", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `scroll-behavior creates initial property`() {
        val rule = Rule("selector")
        rule.`scroll-behavior` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("scroll-behavior", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }
}
