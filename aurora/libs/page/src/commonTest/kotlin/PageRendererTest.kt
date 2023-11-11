package page_lib

import css_lib.base.Document
import css_lib.base.EmptyDocument
import css_lib.base.Property
import css_lib.base.RuleVisitor
import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class PageRendererTest {
    @Mock
    val visitor = mock(classOf<RuleVisitor<String>>())

    @Test
    fun `cssPath is correct`() {
        val pageRenderer = PageRenderer(
            "test",
            EmptyDocument,
            EmptyDocument
        )

        assertEquals("test.css", pageRenderer.cssPath)
    }

    @Test
    fun `extern css is correctly returned`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        every { visitor.result }.returns("p:v;")
        val pageRenderer = PageRenderer(
            "test",
            externalDocument = Document().apply {
                this["c1"] = {
                    +Property.build("p", "v")
                }
            },
            EmptyDocument
        )

        pageRenderer.getExternalCss({visitor})

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `internal css is correctly returned`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        every { visitor.result }.returns("p:v;")
        val pageRenderer = PageRenderer(
            "test",
            EmptyDocument,
            internalDocument = Document().apply {
                this["c1"] = {
                    +Property.build("p", "v")
                }
            },
        )

        pageRenderer.getInternalCss({visitor})

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}
