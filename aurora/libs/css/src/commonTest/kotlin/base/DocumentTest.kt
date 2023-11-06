package css_lib.base

import Callable
import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class DocumentTest {
    @Mock
    val ruleMock = mock(classOf<Callable<Rule>>())
    @Mock
    val visitor = mock(classOf<RuleVisitor<String>>())
    private var document: Document = Document()

    @Test
    fun `test property set works`() {
        document["selector"] = ruleMock::test

        assertEquals(1, document.rules.size)
        assertEquals("selector", document.rules[0].selector)
        verify { ruleMock.test(any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test property set works for multiple classes`() {
        document["selector1", "selector2"] = ruleMock::test

        assertEquals(2, document.rules.size)
        assertEquals("selector1", document.rules[0].selector)
        assertEquals("selector2", document.rules[1].selector)
        verify { ruleMock.test(any()) }
            .wasInvoked(exactly = twice)
    }

    @Test
    fun `visitor is being called`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        val property = Property.build("property", "value")
        document["selector"] = {
            +property
        }
        document.traverse(visitor)

        verify { visitor.visitRule(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `visitor is being called for every rule`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        val property = Property.build("property", "value")
        document["selector1", "selector2"] = {
            +property
        }
        document.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = twice)
    }
}
