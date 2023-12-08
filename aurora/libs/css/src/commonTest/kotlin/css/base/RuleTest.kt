package css.base

import kotlin.test.Test
import kotlin.test.assertEquals

class RuleTest {
    @Test
    fun `rule creation works`() {
        val rule = Rule(object : Selector {
            override fun getType(): SelectorType = SelectorType.UNKNOWN
            override fun asString(): String = "test"
        })

        assertEquals("test", rule.selector.asString())
        assertEquals(SelectorType.UNKNOWN , rule.selector.getType())
    }

    @Test
    fun `rule creation works from Selector`() {
        val selector = object : Selector {
            override fun getType(): SelectorType = SelectorType.UNKNOWN
            override fun asString(): String = "test"
        }
        val rule = selector.rule {  }

        assertEquals("test", rule.selector.asString())
        assertEquals(SelectorType.UNKNOWN , rule.selector.getType())
    }

    @Test
    fun `rule creation works from String`() {
        val selector = "c1"
        val rule = selector.rule {  }

        assertEquals(".c1", rule.selector.asString())
        assertEquals(SelectorType.CLASS , rule.selector.getType())
    }

    @Test
    fun `rule add Property works`() {
        val rule = Rule(object : Selector {
            override fun getType(): SelectorType = SelectorType.UNKNOWN
            override fun asString(): String = "test"
        })
        val propertyList = mutableListOf(Property("a", "b", listOf()))

        rule.apply {
            +propertyList[0]
        }

        assertEquals(propertyList, rule.properties)
    }

    @Test
    fun `rule returns class`() {
        val rule = Rule(Class("test"))

        assertEquals("test", rule.getClass())
    }

    @Test
    fun `rule returns no class for other selectors`() {
        val rule = Rule(Id("test"))

        assertEquals(null, rule.getClass())
    }
}
