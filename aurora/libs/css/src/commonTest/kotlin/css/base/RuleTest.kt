package css.base

import css.base.browser.SupportData
import kotlin.test.Test
import kotlin.test.assertEquals

class RuleTest {
    @Test
    fun `rule creation works`() {
        val rule = Rule(object : Selector {
            override fun getType(): SelectorType = SelectorType.UNKNOWN
            override fun toString(): String = "test"
        })

        assertEquals("test", rule.selector.toString())
        assertEquals(SelectorType.UNKNOWN , rule.selector.getType())
    }

    @Test
    fun `rule add Property works`() {
        val rule = Rule(object : Selector {
            override fun getType(): SelectorType = SelectorType.UNKNOWN
            override fun toString(): String = "test"
        })
        val propertyList: List<IProperty> = mutableListOf(Property("a", "b", SupportData()))

        rule.apply {
            +propertyList[0]
        }

        assertEquals(propertyList, rule.properties)
    }

    @Test
    fun `rule duplicates are removed`() {
        val rule = Rule(object : Selector {
            override fun getType(): SelectorType = SelectorType.UNKNOWN
            override fun toString(): String = "test"
        }).apply {
            +Property("a", "b", SupportData())
            +Property("a", "b", SupportData())
        }

        assertEquals(1, rule.properties.size)
    }
}
