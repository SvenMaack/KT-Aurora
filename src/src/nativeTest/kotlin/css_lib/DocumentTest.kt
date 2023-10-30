package css_lib

import io.mockative.*
import template_lib.tags.Callable
import kotlin.test.Test
import kotlin.test.assertEquals

class DocumentTest {
    @Mock
    val ruleMock = mock(classOf<Callable<Rule>>())
    @Mock
    val visitor = mock(classOf<Visitor<String>>())

    @Test
    fun `test property set works`() {
        val document = Document()
        document["selector"] = ruleMock::test

        assertEquals(1, document.rules.size)
        assertEquals("selector", document.rules[0].selector)
        verify { ruleMock.test(any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test property set works for multiple classes`() {
        val document = Document()
        document["selector1", "selector2"] = ruleMock::test

        assertEquals(2, document.rules.size)
        assertEquals("selector1", document.rules[0].selector)
        assertEquals("selector2", document.rules[1].selector)
        verify { ruleMock.test(any()) }
            .wasInvoked(exactly = twice)
    }

    @Test
    fun `visitor is being called`() {
        val document = Document()
        val property = Property("property", "value")
        document["selector"] = {
            add(property)
        }
        document.traverse(visitor)

        verify { visitor.visitRule(document.rules[0]) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `visitor is being called for every rule`() {
        val document = Document()
        val property = Property("property", "value")
        document["selector1", "selector2"] = {
            add(property)
        }
        document.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = twice)
    }
}
