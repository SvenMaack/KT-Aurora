package css_lib.base

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

        documentList.add(childDocument)

        assertEquals(1, documentList.documents.size)
        assertSame(childDocument, documentList.documents[0])
    }

    @Test
    fun `visitor is being called on child`() {
        every { visitor.visitRule(any()) }.returns(visitor)

        val documentList = DocumentList()
        val childDocument = Document()

        documentList.add(childDocument)
        childDocument["selector"] = {
            +Property.build("property", "value")
        }

        documentList.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}
