package template_lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame
import kotlin.test.assertTrue

class TagContainerTest {
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())

    @Test
    fun `add adds a children`() {
        val tag = TagContainer("a")
        assertEquals(0, tag.children.size)
        tag.add(TagContainer("b"))
        assertEquals(1, tag.children.size)
        tag.add(TagContainer("c"))
        assertEquals(2, tag.children.size)
    }

    @Test
    fun `visitor is being called`() {
        val tag = TagContainer("a")

        tag.traverse(htmlVisitor)

        verify { htmlVisitor.visitTagContainerBegin(tag) }
            .wasInvoked(exactly = once)
        verify { htmlVisitor.visitTagContainerEnd(tag) }
            .wasInvoked(exactly = once)

        verify { htmlVisitor.visitTagWithAttributes(tag) }
            .wasNotInvoked()
        verify { htmlVisitor.visitTag(tag) }
            .wasNotInvoked()
    }

    @Test
    fun `visitor of child is being called`() {
        val tag = Tag("b")
        val tagContainer = TagContainer("a")
        tagContainer.add(tag)

        tagContainer.traverse(htmlVisitor)

        verify { htmlVisitor.visitTag(tag) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `adding comment works`() {
        val tagContainer = TagContainer("a")
        tagContainer.apply { !"comment" }

        assertEquals(1, tagContainer.children.size)
        assertTrue { tagContainer.children[0] is Comment }
        assertEquals( "!--comment--", (tagContainer.children[0] as Comment).name)
    }

    @Test
    fun `adding children works`() {
        val tagContainer = TagContainer("a")
        val tagContainer2 = TagContainer("a2")
        tagContainer.addAll(listOf(tagContainer2))

        assertEquals(1, tagContainer.children.size)
        assertSame(tagContainer2, tagContainer.children[0])
    }
}
