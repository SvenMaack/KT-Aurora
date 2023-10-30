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
}
