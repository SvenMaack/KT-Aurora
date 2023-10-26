package lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TagTest {
    @Mock
    val visitor = mock(classOf<Visitor<String>>())

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

        tag.traverse(visitor)

        verify { visitor.visitTag(tag) }
            .wasInvoked(exactly = once)
    }
}
