package css.base

import css.base.browser.SupportData
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
            +Property("property", "value", SupportData())
        }

        result.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `document duplicates are skipped`() {
        every { visitor.visitRule(any()) }.returns(visitor)

        val documentList = DocumentList()
        val childDocument = Document()
        val result = documentList + childDocument + childDocument
        childDocument["selector"] = {
            +Property("property", "value", SupportData())
        }

        result.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }


    @Test
    fun `document duplicates are skipped even when nested`() {
        every { visitor.visitRule(any()) }.returns(visitor)

        val childDocument = Document()
        val result = DocumentList().apply {
            +childDocument
            +DocumentList().apply {
                +DocumentList().apply {
                    +childDocument
                }
            }
        }

        childDocument["selector"] = {
            +Property("property", "value", SupportData())
        }

        result.traverse(visitor)

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}
