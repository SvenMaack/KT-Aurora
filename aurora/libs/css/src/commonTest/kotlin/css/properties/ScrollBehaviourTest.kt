package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ScrollBehaviourTest {
    @Test
    fun `scroll-behavior`() {
        ScrollBehaviour.entries.forEach {
            val rule = Rule("selector")
            rule.`scroll-behavior`(it)
            check(rule, it)
        }
    }

    private fun check(rule: Rule, entries: ScrollBehaviour) {
        assertEquals(1, rule.properties.size)
        assertEquals("scroll-behavior", rule.properties[0].property)
        assertEquals(entries.value, rule.properties[0].value)
    }
}
