package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class PositionTest {
    @Test
    fun `test position`() {
        PositionValue.entries.forEach {
            val rule = Rule("selector")
            rule.position(it)
            check(rule, "position", it.value)
        }
    }

    @Test
    fun `test top`() {
        val rule = Rule("selector")
        rule.top(PositionDistanceValue.inherit)
        check(rule, "top", "inherit")
    }

    @Test
    fun `test top-value`() {
        val rule = Rule("selector")
        rule.top(5.px)
        check(rule, "top", "5px")
    }

    @Test
    fun `test right`() {
        val rule = Rule("selector")
        rule.right(PositionDistanceValue.inherit)
        check(rule, "right", "inherit")
    }

    @Test
    fun `test right-value`() {
        val rule = Rule("selector")
        rule.right(5.px)
        check(rule, "right", "5px")
    }

    @Test
    fun `test bottom`() {
        val rule = Rule("selector")
        rule.bottom(PositionDistanceValue.inherit)
        check(rule, "bottom", "inherit")
    }

    @Test
    fun `test bottom-value`() {
        val rule = Rule("selector")
        rule.bottom(5.px)
        check(rule, "bottom", "5px")
    }

    @Test
    fun `test left`() {
        val rule = Rule("selector")
        rule.left(PositionDistanceValue.inherit)
        check(rule, "left", "inherit")
    }

    @Test
    fun `test left-value`() {
        val rule = Rule("selector")
        rule.left(5.px)
        check(rule, "left", "5px")
    }

    private fun check(rule: Rule, property: String, value: String) {
        assertEquals(1, rule.properties.size)
        assertEquals(property, rule.properties[0].property)
        assertEquals(value, rule.properties[0].value)
    }
}