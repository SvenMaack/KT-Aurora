package template_lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TagWithTextTest {
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())

    @Test
    fun `text is saved correctly`() {
        val tag = TagWithText("p")
        with(tag) {
            +"Lorem"
        }
        assertEquals("Lorem", (tag.children.first() as TextElement).text)
    }

    @Test
    fun `adding text adds a child`() {
        val tag = TagWithText("p")
        assertEquals(0, tag.children.size)
        with(tag) {
            +"Lorem"
        }
        assertEquals(1, tag.children.size)
    }

    @Test
    fun `visitor is being called`() {
        val tag = TagWithText("p")
        val tx: TextElement?
        with(tag) {
            tx = +"Lorem"
        }

        tag.traverse(htmlVisitor)

        verify { htmlVisitor.visitTextElement(tx!!) }
            .wasInvoked(exactly = once)
        verify { htmlVisitor.visitTagContainerBegin(tag) }
            .wasInvoked(exactly = once)
        verify { htmlVisitor.visitTagContainerEnd(tag) }
            .wasInvoked(exactly = once)

        verify { htmlVisitor.visitTag(tag) }
            .wasNotInvoked()
        verify { htmlVisitor.visitTagWithAttributes(tag) }
            .wasNotInvoked()
    }
}
