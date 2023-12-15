package css.base

import css.base.browser.SupportData
import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class DocumentTest {
    @Mock
    val visitor = mock(classOf<RuleVisitor<String>>())
    @Mock
    val blockRule = mock(classOf<Fun1<IRule, Unit>>())

    @Test
    fun `rule definition by class works`() {
        every { blockRule.invoke(any()) }.returns(Unit)

        val document = Document().apply {
            clazz["c1"] = blockRule::invoke
        }

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.CLASS, document.rules[0].selector.getType())
        assertEquals(".c1", document.rules[0].selector.toString())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by class works with several selectors`() {
        every { blockRule.invoke(any()) }.returns(Unit)

        val document = Document().apply {
            clazz["c1", "c2"] = blockRule::invoke
        }

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.COMBINATOR, document.rules[0].selector.getType())
        assertEquals(".c1,.c2", document.rules[0].selector.toString())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by tag works`() {
        every { blockRule.invoke(any()) }.returns(Unit)

        val document = Document().apply {
            tag["tag"] = blockRule::invoke
        }

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.TAG, document.rules[0].selector.getType())
        assertEquals("tag", document.rules[0].selector.toString())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by tag works with several selectors`() {
        every { blockRule.invoke(any()) }.returns(Unit)

        val document = Document().apply {
            tag["tag1", "tag2"] = blockRule::invoke
        }

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.COMBINATOR, document.rules[0].selector.getType())
        assertEquals("tag1,tag2", document.rules[0].selector.toString())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by id works`() {
        every { blockRule.invoke(any()) }.returns(Unit)

        val document = Document().apply {
            id["i"] = blockRule::invoke
        }

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.ID, document.rules[0].selector.getType())
        assertEquals("#i", document.rules[0].selector.toString())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by id works with several selectors`() {
        every { blockRule.invoke(any()) }.returns(Unit)

        val document = Document().apply {
            id["i1", "i2"] = blockRule::invoke
        }

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.COMBINATOR, document.rules[0].selector.getType())
        assertEquals("#i1,#i2", document.rules[0].selector.toString())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by selector works`() {
        every { blockRule.invoke(any()) }.returns(Unit)
        val document = Document()
        document[Class("c1")] = blockRule::invoke

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.CLASS, document.rules[0].selector.getType())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `rule definition by selector works with several selectors`() {
        every { blockRule.invoke(any()) }.returns(Unit)
        val document = Document()
        document[Class("c1"), Class("c2")] = blockRule::invoke

        assertEquals(1, document.rules.size)
        assertEquals(SelectorType.COMBINATOR, document.rules[0].selector.getType())
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `add rule works`() {
        val document = Document()
        val rule = Rule("c1")
        document.apply {
            +rule
        }

        assertEquals(1, document.rules.size)
        assertSame(rule, document.rules[0])
    }

    @Test
    fun `visitor is being called`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        val property = Property("property", "value", SupportData())
        val document = Document().apply {
            clazz["selector"] = {
                +property
            }
        }
        document.traverse(visitor)

        verify { visitor.visitRule(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `visitor is being called for every rule`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        val property = Property("property", "value", SupportData())
        val document = Document().apply {
            clazz["s1"] = {
                +property
            }
            clazz["s2"] = {
                +property
            }
        }
        document.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = twice)
    }

    @Test
    fun `empty document is empty`() {
        assertEquals(0, (EmptyDocument as Document).rules.size)
    }
}
