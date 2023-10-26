package lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TagWithTextTest {
    @Mock
    val visitor = mock(classOf<Visitor<String>>())

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

        tag.traverse(visitor)

        verify { visitor.visitTextElement(tx!!) }
            .wasInvoked(exactly = once)
    }
}
