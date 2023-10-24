package lib.base

import io.mockative.configure
import io.mockative.Mock
import io.mockative.mock
import io.mockative.classOf
import io.mockative.verify
import io.mockative.time
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TagContainerTest {
    @Mock
    val api = configure(mock(classOf<Visitor<String>>())) {
        stubsUnitByDefault = true
    }

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

        tag.traverse(api)

        verify(api)
            .invocation {
                visitTagContainerBegin(tag)
            }
            .wasInvoked(exactly = 1.time)
        verify(api)
            .invocation {
                visitTagContainerEnd(tag)
            }
            .wasInvoked(exactly = 1.time)
    }

    @Test
    fun `visitor of child is being called`() {
        val tag = Tag("b")
        val tagContainer = TagContainer("a")
        tagContainer.add(tag)

        tagContainer.traverse(api)

        verify(api)
            .invocation {
                visitTag(tag)
            }
            .wasInvoked(exactly = 1.time)
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
