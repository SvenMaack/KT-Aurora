package lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CommentTest {
    @Mock
    val visitor = mock(classOf<Visitor<String>>())

    @Test
    fun `comment is set correctly`() {
        assertEquals("!--p--", Comment("p").name)
    }

    @Test
    fun `empty comment is set correctly`() {
        assertEquals("!----", Comment("").name)
    }

    @Test
    fun `visitor is being called`() {
        val comment = Comment("comment")
        comment.traverse(visitor)

        verify { visitor.visitComment(comment) }
            .wasInvoked(exactly = once)
    }
}
