package lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TagContainerTest {
    @Mock
    val visitor = mock(classOf<Visitor<String>>())

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

        tag.traverse(visitor)

        verify { visitor.visitTagContainerBegin(tag) }
            .wasInvoked(exactly = once)

        verify { visitor.visitTagContainerEnd(tag) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `visitor of child is being called`() {
        val tag = Tag("b")
        val tagContainer = TagContainer("a")
        tagContainer.add(tag)

        tagContainer.traverse(visitor)

        verify { visitor.visitTag(tag) }
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
}