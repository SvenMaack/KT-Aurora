package css.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class DocumentListTest {
    @Mock
    val visitor = mock(classOf<RuleVisitor<String>>())

    @Test
    fun `test add document works`() {
        val documentList = DocumentList()
        val childDocument = Document()

        val result = documentList + childDocument

        assertEquals(1, result.documents.size)
        assertSame(childDocument, result.documents[0])
    }

    @Test
    fun `visitor is being called on child`() {
        every { visitor.visitRule(any()) }.returns(visitor)

        val documentList = DocumentList()
        val childDocument = Document()
        val result = documentList + childDocument
        childDocument["selector"] = {
            +Property("property", "value", listOf())
        }

        result.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}
