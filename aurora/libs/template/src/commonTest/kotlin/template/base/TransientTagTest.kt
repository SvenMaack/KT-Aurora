package template.base

import io.mockative.*
import kotlin.test.Test

class TransientTagTest {
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())

    @Test
    fun `visitor is not called`() {
        val tag = TransientTag()

        tag.traverse(htmlVisitor)

        verify { htmlVisitor.visitTag(tag) }
            .wasNotInvoked()
        verify { htmlVisitor.visitTagWithAttributes(tag) }
            .wasNotInvoked()
        verify { htmlVisitor.visitTagContainerBegin(tag) }
            .wasNotInvoked()
        verify { htmlVisitor.visitTagContainerEnd(tag) }
            .wasNotInvoked()
    }
}
