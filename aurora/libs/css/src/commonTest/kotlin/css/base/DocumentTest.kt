package css.base

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
    fun `property set by selector works`() {
        every { blockRule.invoke(any()) }.returns(Unit)
        val document = Document()
        document[Class("c1")] = blockRule::invoke

        assertEquals(1, document.rules.size)
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test property set by selector works for multiple properties`() {
        every { blockRule.invoke(any()) }.returns(Unit)
        val document = Document()
        document[Class("c1"), Class("c2")] = blockRule::invoke

        assertEquals(2, document.rules.size)
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
        verify { blockRule.invoke(document.rules[1]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `property set by string works`() {
        every { blockRule.invoke(any()) }.returns(Unit)
        val document = Document()
        document["c1"] = blockRule::invoke

        assertEquals(1, document.rules.size)
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test property set by string works for multiple properties`() {
        every { blockRule.invoke(any()) }.returns(Unit)
        val document = Document()
        document["c1", "c2"] = blockRule::invoke

        assertEquals(2, document.rules.size)
        verify { blockRule.invoke(document.rules[0]) }
            .wasInvoked(exactly = once)
        verify { blockRule.invoke(document.rules[1]) }
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
        val property = Property("property", "value", listOf())
        val document = Document().apply {
            this["selector"] = {
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
        val property = Property("property", "value", listOf())
        val document = Document().apply {
            this["s1", "s2"] = {
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
