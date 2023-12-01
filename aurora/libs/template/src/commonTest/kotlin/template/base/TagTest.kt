package template.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TagTest {
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())

    @Test
    fun `tag is set correctly`() {
        assertEquals("p", Tag("p").name)
    }

    @Test
    fun `tag is set correctly with special characters`() {
        assertEquals("!- p", Tag("!- p").name)
    }

    @Test
    fun `visitor is being called`() {
        val tag = Tag("a")

        tag.traverse(htmlVisitor)

        verify { htmlVisitor.visitTag(tag) }
            .wasInvoked(exactly = once)
    }
}
