package template_lib

import io.mockative.*
import template_lib.base.TagContainer
import template_lib.base.HtmlVisitor
import template_lib.base.HtmlVisitorStrategy
import kotlin.test.Test

class TemplateCacheTest {
    @Mock
    val htmlVisitorMock = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val staticTemplateMock = mock(classOf<Callable2R<Context, Unit, TagContainer>>())
    @Mock
    val htmlVisitorStrategyMock = mock(classOf<HtmlVisitorStrategy<String>>())
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())

    @Test
    fun `test cache works`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { staticTemplateMock.test(context, Unit) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { templateRendererMock.render<Unit>(any(), any(), any()) }.returns("test")

        TemplateCache.clear()

        TemplateCache[context, staticTemplateMock::test]
        TemplateCache[context, staticTemplateMock::test]

        verify { templateRendererMock.render(context, staticTemplateMock::test, Unit) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test clear works`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { staticTemplateMock.test(context, Unit) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { templateRendererMock.render<Unit>(any(), any(), any()) }.returns("test")

        TemplateCache.clear()

        TemplateCache[context, staticTemplateMock::test]
        TemplateCache.clear()
        TemplateCache[context, staticTemplateMock::test]

        verify { templateRendererMock.render(context, staticTemplateMock::test, Unit) }
            .wasInvoked(exactly = twice)
    }
}