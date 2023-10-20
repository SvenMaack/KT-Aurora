package unit.lib.base

import io.mockative.*
import lib.base.Comment
import lib.base.Visitor
import kotlin.test.Test
import kotlin.test.assertEquals

class CommentTest {
    @Mock
    val api = configure(mock(classOf<Visitor>())) {
        stubsUnitByDefault = true
    }

    @Test
    fun `comment is set correctly`() {
        assertEquals("!--p--", Comment("p").tagName)
    }

    @Test
    fun `empty omment is set correctly`() {
        assertEquals("!----", Comment("").tagName)
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
