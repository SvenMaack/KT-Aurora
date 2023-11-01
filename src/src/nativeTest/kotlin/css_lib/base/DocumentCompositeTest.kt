package css_lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class DocumentCompositeTest {
    @Mock
    val visitor = mock(classOf<RuleVisitor<String>>())

    @Test
    fun `test add document works`() {
        val parentDocument = DocumentComposite()
        val childDocument = Document()

        parentDocument.addDocument(childDocument)

        assertEquals(1, parentDocument.documents.size)
        assertSame(childDocument, parentDocument.documents[0])
    }

    @Test
    fun `visitor is being called on child`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        val parentDocument = DocumentComposite()
        val childDocument = Document()
        childDocument["selector"] = {
            +Property.build("property", "value")
        }
        parentDocument.addDocument(childDocument)

        parentDocument.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}