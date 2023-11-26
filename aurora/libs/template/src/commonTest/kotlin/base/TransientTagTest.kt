package template_lib.base

import io.mockative.*
import kotlin.test.Test

class TransientTagTest {
    @Mock
    val visitor = mock(classOf<Visitor<String>>())

    @Test
    fun `visitor is not called`() {
        val tag = TransientTag()

        tag.traverse(visitor)

        verify { visitor.visitTag(tag) }
            .wasNotInvoked()
        verify { visitor.visitTagWithAttributes(tag) }
            .wasNotInvoked()
        verify { visitor.visitTagContainerBegin(tag) }
            .wasNotInvoked()
        verify { visitor.visitTagContainerEnd(tag) }
            .wasNotInvoked()
        verify { visitor.visitTagWithText(tag) }
            .wasNotInvoked()
    }
}
