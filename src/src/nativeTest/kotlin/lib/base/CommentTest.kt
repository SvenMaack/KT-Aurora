package lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CommentTest {
    @Mock
    val api = configure(mock(classOf<Visitor<String>>())) {
        stubsUnitByDefault = true
    }

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
        comment.traverse(api)
        verify(api)
            .invocation {
                visitComment(comment)
            }
            .wasInvoked(exactly = 1.time)
    }
}
