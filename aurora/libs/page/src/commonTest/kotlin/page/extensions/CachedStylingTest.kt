package page.extensions

import css.ICssRenderer
import css.base.Document
import css.base.RuleVisitorFactory
import io.mockative.Mock
import io.mockative.any
import io.mockative.classOf
import io.mockative.every
import io.mockative.mock
import io.mockative.once
import io.mockative.twice
import io.mockative.verify
import kotlin.test.Test

class CachedStylingTest {
    @Mock
    val cssRendererMock = mock(classOf<ICssRenderer<String>>())
    @Mock
    val ruleVisitorMock = mock(classOf<RuleVisitorFactory<String>>())

    @Test
    fun `cache works`() {
        val document = Document()
        every { cssRendererMock.render(ruleVisitorMock, document) }.returns("test")

        val cachedStyling = CachedStyling(cssRendererMock)

        cachedStyling.render(ruleVisitorMock, document)
        cachedStyling.render(ruleVisitorMock, document)

        verify { cssRendererMock.render(ruleVisitorMock, document) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `cache distinguish document`() {
        val document1 = Document()
        val document2 = Document()
        every { cssRendererMock.render(ruleVisitorMock, document1) }.returns("test")
        every { cssRendererMock.render(ruleVisitorMock, document2) }.returns("test")

        val cachedStyling = CachedStyling(cssRendererMock)

        cachedStyling.render(ruleVisitorMock, document1)
        cachedStyling.render(ruleVisitorMock, document2)

        verify { cssRendererMock.render(any(), any()) }
            .wasInvoked(exactly = twice)
    }
}
